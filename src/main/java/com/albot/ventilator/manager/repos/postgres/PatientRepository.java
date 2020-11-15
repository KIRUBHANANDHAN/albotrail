package com.albot.ventilator.manager.repos.postgres;

import com.albot.ventilator.manager.model.dto.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    List<PatientEntity> findAll();

    PatientEntity findAllById(Integer patientId);

    //List<PatientEntity> findAllByUserDemoGraphicsEntity(String Username);
    //PatientEntity insert(PatientEntity patientEntity);
    PatientEntity save(PatientEntity patientEntity);
}
