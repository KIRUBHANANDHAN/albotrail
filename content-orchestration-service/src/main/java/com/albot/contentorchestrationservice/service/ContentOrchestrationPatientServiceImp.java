package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.cassandra.entity.PatientEntity;
import com.albot.contentorchestrationservice.cassandra.repository.PatientRepository;
import com.albot.contentorchestrationservice.dto.Patients;
import com.albot.contentorchestrationservice.exception.BadStatusRequestException;
import com.albot.contentorchestrationservice.exception.PatientSubjectIdNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ContentOrchestrationPatientServiceImp implements ContentOrchestrationPatientService {

    private PatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public ContentOrchestrationPatientServiceImp(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patients> getAllPatients() {
        return convertToListPatients(patientRepository.findAll());
    }

    @Override
    public Patients getBySubjectId(Integer subjectId) {
        PatientEntity patientEntity = patientRepository.findBySubjectId(subjectId);
        if(!Objects.isNull(patientEntity)) {
            if (patientEntity.getStatusFlag() == Boolean.TRUE) {
                throw new BadStatusRequestException(
                        String.format("Invalid  subjectId value as a %d, Please provide correct subjectId", subjectId));
            }
        } else{
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
        return convertToPatients(
                patientRepository.insert(patientEntity));
    }

    @Override
    public Patients updatePatients(Patients patients) {
        return convertToPatients(
                patientRepository.save(convertToPatientsEntity(patients)));
    }

    @Override
    public void deletePatientsBySubjectId(Integer subjectId) {
        PatientEntity patientEntity = patientRepository.findBySubjectId(subjectId);
        if (!Objects.isNull(patientEntity) && subjectId.equals(patientEntity.getSubjectId()) ) {
            patientEntity.setStatusFlag(Boolean.TRUE);
            patientRepository.save(patientEntity);
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
