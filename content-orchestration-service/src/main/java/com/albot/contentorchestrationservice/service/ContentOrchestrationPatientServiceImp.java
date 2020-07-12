package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.cassandra.entity.PatientEntity;
import com.albot.contentorchestrationservice.cassandra.repository.PatientRepository;
import com.albot.contentorchestrationservice.dto.Patients;
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
        return null;
    }

    @Override
    public Patients getBySubjectId(Integer subjectId) {
        return convertToPatientsEntity(
                patientRepository.findBySubjectId(subjectId));
    }

    @Override
    public Patients createPatients(Patients patients) {
        return convertToPatientsEntity(
                patientRepository.insert(convertToPatients(patients)));
    }

    @Override
    public Patients updatePatients(Patients patients) {
        return convertToPatientsEntity(
                patientRepository.save(convertToPatients(patients)));
    }

    private PatientEntity convertToPatients(Patients patients) {
        return modelMapper
                .map(patients, PatientEntity.class);
    }

    private Patients convertToPatientsEntity(PatientEntity patientEntity) {
        if (Objects.isNull(patientEntity)) {
            return new Patients();
        }
        return modelMapper
                .map(patientEntity, Patients.class);
    }
}
