package com.albot.contentorchestrationservice.cassandra.repository;

import com.albot.contentorchestrationservice.cassandra.entity.CptEventEntity;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface CptEventRepository extends CassandraRepository<CptEventEntity, Integer> {

    List<CptEventEntity> findAll();

    @AllowFiltering
    CptEventEntity findBySubjectId(Integer subjectId);

    CptEventEntity insert(CptEventEntity cptEventEntity);

    CptEventEntity save(CptEventEntity cptEventEntity);
}
