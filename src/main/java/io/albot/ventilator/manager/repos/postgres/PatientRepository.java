package io.albot.ventilator.manager.repos.postgres;

import io.albot.ventilator.manager.model.dto.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    List<PatientEntity> findAll();

    @Query("SELECT t FROM PatientEntity t WHERE t.id = :id")
    PatientEntity findAllById(@Param("id") Integer id);


    PatientEntity save(PatientEntity patientEntity);
}
