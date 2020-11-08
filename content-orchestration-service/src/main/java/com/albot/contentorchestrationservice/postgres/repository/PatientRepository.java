package com.albot.contentorchestrationservice.postgres.repository;

import com.albot.contentorchestrationservice.postgres.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    List<PatientEntity> findAll();

    PatientEntity findAllById(Integer patientId);
    //List<PatientEntity> findAllByUserDemoGraphicsEntity(String Username);
    //PatientEntity insert(PatientEntity patientEntity);
    PatientEntity save(PatientEntity patientEntity);
}
