package com.albot.contentorchestrationservice.cassandra.repository;

import com.albot.contentorchestrationservice.cassandra.entity.PatientEntity;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;


public interface PatientRepository extends CassandraRepository<PatientEntity, Integer> {

    List<PatientEntity> findAll();

    @AllowFiltering
    PatientEntity findBySubjectId(Integer subjectId);

    PatientEntity insert(PatientEntity patientEntity);

    PatientEntity save(PatientEntity patientEntity);
}
