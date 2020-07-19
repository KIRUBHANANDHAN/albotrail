package com.albot.contentorchestrationservice.cassandra.repository;

import com.albot.contentorchestrationservice.cassandra.entity.CurrentProceduralTerminologyEntity;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface CurrentProceduralTerminologyRepository extends CassandraRepository<CurrentProceduralTerminologyEntity, Integer> {

    List<CurrentProceduralTerminologyEntity> findAll();

    @AllowFiltering
    CurrentProceduralTerminologyEntity findByRowId(Integer findByRowId);

    CurrentProceduralTerminologyEntity insert(CurrentProceduralTerminologyEntity cpt);

    CurrentProceduralTerminologyEntity save(CurrentProceduralTerminologyEntity cpt);
}
