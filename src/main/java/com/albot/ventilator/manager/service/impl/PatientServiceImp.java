package com.albot.ventilator.manager.service.impl;

import com.albot.ventilator.manager.exceptions.BadStatusRequestException;
import com.albot.ventilator.manager.exceptions.PatientSubjectIdNotFoundException;
import com.albot.ventilator.manager.model.dto.PatientEntity;
import com.albot.ventilator.manager.model.web.Patients;
import com.albot.ventilator.manager.repos.postgres.PatientRepository;
import com.albot.ventilator.manager.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class PatientServiceImp implements PatientService {

    private static final Logger logger = LoggerFactory.getLogger(PatientServiceImp.class);

    private final PatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public PatientServiceImp(PatientRepository patientRepository) {
        logger.info("Initialization of the patientRepository object in patient service");
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patients> getAllPatients() {
        logger.info("Making call to database for fetching list of patient information");
        return convertToListPatients(patientRepository.findAll());
    }

    @Override
    public Patients getByPatientId(Integer patientId) {
        PatientEntity patientEntity = patientRepository.findAllById(patientId);
        logger.info("Successfully retrieved patient information based on condition : patientId : {} and data : {} ", patientId, patientEntity);
        if (!Objects.isNull(patientEntity)) {
            if (patientEntity.getStatusFlag() == Boolean.TRUE) {
                logger.error("Failed to retrieve patient information based on condition : patientId : {} because of  data is deleted and  flag status is {}",
                        patientId, patientEntity.getStatusFlag());
                throw new BadStatusRequestException(
                        String.format("Invalid  patientId value as a %d, Please provide correct patientId", patientId));
            }
        } else {
            logger.error("Patient information data not found in database based on condition : patientId = {} ", patientId);
            throw new PatientSubjectIdNotFoundException(
                    String.format("Given patientId not found in patient information with value  %d", patientId));
        }
        return convertToPatients(
                patientEntity);
    }

    @Override
    public Patients createPatients(Patients patients) {
        PatientEntity patientEntity = convertToPatientsEntity(patients);
        patientEntity.setStatusFlag(Boolean.FALSE);
        logger.info("Making call to database for saving patient information : {}", patientEntity);
        Patients patientsInfo = convertToPatients(
                patientRepository.save(patientEntity));
        /*try {
            ElasticSearchUtility.restClient(Util.IndexType.PATIENT.name().toLowerCase(),
                    String.valueOf(patientsInfo.getSubjectId()), Util.toObjectToJson(patientsInfo));
        } catch (JsonProcessingException e) {
            logger.error("Failed to process object mapper to converter java object to json: {}", e);
        }*/
        log.info("Return patientsInfo response");
        return patientsInfo;
    }

    @Override
    public Patients updatePatients(Patients patients) {
        logger.info("Making call to database for updating patient information : {}", patients);
        return convertToPatients(
                patientRepository.save(convertToPatientsEntity(patients)));
    }

    @Override
    public void deletePatientByPatientId(Integer patientId) {
        PatientEntity patientEntity = patientRepository.findAllById(patientId);
        logger.info("Successfully retrieved patient information based on condition : patientId : {} and data : {} for deleting", patientId, patientEntity);
        if (!Objects.isNull(patientEntity) && patientId.equals(patientEntity.getSubjectId())) {
            patientEntity.setStatusFlag(Boolean.TRUE);
            logger.info("Making call to databased for updating flag : {}  and data : {} ", patientEntity.getStatusFlag(), patientEntity);
            patientRepository.save(patientEntity);
            logger.info("Successfully updated flag in patient service based on condition : patientId = {} in case of delete", patientId);
        } else {
            throw new PatientSubjectIdNotFoundException(
                    String.format("Given patientId with value %d not found in patient information, Please provide correct patientId", patientId));
        }
    }

    private PatientEntity convertToPatientsEntity(Patients patients) {
        return modelMapper
                .map(patients, PatientEntity.class);
    }

    private Patients convertToPatients(PatientEntity patientEntity) {
        return modelMapper
                .map(patientEntity, Patients.class);
    }

    private List<Patients> convertToListPatients(List<PatientEntity> patientEntities) {
        return modelMapper
                .map(patientEntities, List.class);
    }
}
