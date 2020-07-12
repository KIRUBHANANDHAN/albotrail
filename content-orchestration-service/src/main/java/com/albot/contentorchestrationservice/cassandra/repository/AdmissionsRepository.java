package com.albot.contentorchestrationservice.cassandra.repository;

import com.albot.contentorchestrationservice.cassandra.entity.AdmissionsEntity;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.List;


public interface AdmissionsRepository extends CassandraRepository<AdmissionsEntity, Integer> {

    List<AdmissionsEntity> findAll();

    @AllowFiltering
    AdmissionsEntity findByhadmId(Integer hadmId);

    AdmissionsEntity insert(AdmissionsEntity admissionsEntity);

    AdmissionsEntity save(AdmissionsEntity admissionsEntity);
}
