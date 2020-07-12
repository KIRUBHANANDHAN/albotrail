package com.albot.contentorchestrationservice.cassandra.repository;

import com.albot.contentorchestrationservice.cassandra.entity.PatientEntity;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.List;


public interface PatientRepository extends CassandraRepository<PatientEntity, Integer> {

    public List<PatientEntity> findAll();

    @AllowFiltering
    public PatientEntity findBySubjectId(Integer subjectId);

    public PatientEntity insert(PatientEntity patientEntity);

    public PatientEntity save(PatientEntity patientEntity);
}
