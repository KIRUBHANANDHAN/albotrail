package com.albot.contentorchestrationservice.cassandra.repository;

import com.albot.contentorchestrationservice.cassandra.entity.CareGiversEntity;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.List;


public interface CareGiversRepository extends CassandraRepository<CareGiversEntity, Integer> {

    public List<CareGiversEntity> findAll();

    @AllowFiltering
    public CareGiversEntity findBycgId(Integer cgId);

    public CareGiversEntity insert(CareGiversEntity careGiversEntity);

    public CareGiversEntity save(CareGiversEntity careGiversEntity);

}
