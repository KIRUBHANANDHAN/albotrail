package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.cassandra.entity.PatientEntity;
import com.albot.contentorchestrationservice.cassandra.repository.PatientRepository;
import com.albot.contentorchestrationservice.dto.Patients;
import com.albot.contentorchestrationservice.exception.BadStatusRequestException;
import com.albot.contentorchestrationservice.exception.PatientSubjectIdNotFoundException;
import com.albot.contentorchestrationservice.util.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
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
public class ContentOrchestrationPatientServiceImp implements ContentOrchestrationPatientService {

    private static final Logger logger = LoggerFactory.getLogger(ContentOrchestrationPatientServiceImp.class);

    private PatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public ContentOrchestrationPatientServiceImp(PatientRepository patientRepository) {
        logger.info("Initialization of the patientRepository object in patient service");
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patients> getAllPatients() {
        logger.info("Making call to database for fetching list of patient information");
        return convertToListPatients(patientRepository.findAll());
    }

    @Override
    public Patients getBySubjectId(Integer subjectId) {
        PatientEntity patientEntity = patientRepository.findBySubjectId(subjectId);
        logger.info("Successfully retrieved patient information based on condition : subjectId : {} and data : {} ", subjectId, patientEntity);
        if(!Objects.isNull(patientEntity)) {
            if (patientEntity.getStatusFlag() == Boolean.TRUE) {
                logger.error("Failed to retrieve patient information based on condition : subjectId : {} because of  data is deleted and  flag status is {}",
                        subjectId, patientEntity.getStatusFlag());
                throw new BadStatusRequestException(
                        String.format("Invalid  subjectId value as a %d, Please provide correct subjectId", subjectId));
            }
        } else{
            logger.error("Patient information data not found in database based on condition : subjectId = {} ", subjectId);
            throw new PatientSubjectIdNotFoundException(
                    String.format("Given subjectId not found in patient information with value  %d", subjectId));
        }
        return convertToPatients(
                patientEntity);
    }

    @Override
    public Patients createPatients(Patients patients) {
        PatientEntity patientEntity = convertToPatientsEntity(patients);
        patientEntity.setStatusFlag(Boolean.FALSE);
        logger.info("Making call to database for saving patient information : {}" ,patientEntity);
        Patients patientsInfo =  convertToPatients(
                patientRepository.insert(patientEntity));
        try {
            ElasticSearchUtility.restClient(Util.IndexType.PATIENT.name().toLowerCase(),
                    String.valueOf(patientsInfo.getSubjectId()), Util.toObjectToJson(patientsInfo));
        } catch (JsonProcessingException e) {
            logger.error("Failed to process object mapper to converter java object to json: {}", e);
        }
        log.info("Return patientsInfo response");
        return patientsInfo;
    }

    @Override
    public Patients updatePatients(Patients patients) {
        logger.info("Making call to database for updating patient information : {}" ,patients);
        return convertToPatients(
                patientRepository.save(convertToPatientsEntity(patients)));
    }

    @Override
    public void deletePatientsBySubjectId(Integer subjectId) {
        PatientEntity patientEntity = patientRepository.findBySubjectId(subjectId);
        logger.info("Successfully retrieved patient information based on condition : subjectId : {} and data : {} for deleting", subjectId ,patientEntity);
        if (!Objects.isNull(patientEntity) && subjectId.equals(patientEntity.getSubjectId()) ) {
            patientEntity.setStatusFlag(Boolean.TRUE);
            logger.info("Making call to databased for updating flag : {}  and data : {} ", patientEntity.getStatusFlag(), patientEntity);
            patientRepository.save(patientEntity);
            logger.info("Successfully updated flag in patient service based on condition : subjectId = {} in case of delete", subjectId);
        } else {
             throw new PatientSubjectIdNotFoundException(
                     String.format("Given subjectId with value %d not found in patient information, Please provide correct subjectId", subjectId));
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
