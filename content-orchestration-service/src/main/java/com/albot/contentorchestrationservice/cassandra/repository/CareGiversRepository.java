package com.albot.contentorchestrationservice.cassandra.repository;

import com.albot.contentorchestrationservice.cassandra.entity.CareGiversEntity;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.List;


public interface CareGiversRepository extends CassandraRepository<CareGiversEntity, Integer> {

     List<CareGiversEntity> findAll();

     @AllowFiltering
     CareGiversEntity findBycgId(Integer cgId);

     CareGiversEntity insert(CareGiversEntity careGiversEntity);

     CareGiversEntity save(CareGiversEntity careGiversEntity);

}
