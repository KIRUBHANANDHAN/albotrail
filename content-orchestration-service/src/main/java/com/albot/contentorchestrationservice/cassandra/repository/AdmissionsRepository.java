package com.albot.contentorchestrationservice.cassandra.repository;

import com.albot.contentorchestrationservice.cassandra.entity.AdmissionsEntity;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.List;


public interface AdmissionsRepository extends CassandraRepository<AdmissionsEntity, Integer> {

    public List<AdmissionsEntity> findAll();

    @AllowFiltering
    public AdmissionsEntity findByhadmId(Integer hadmId);

    public AdmissionsEntity insert(AdmissionsEntity admissionsEntity);

    public AdmissionsEntity save(AdmissionsEntity admissionsEntity);
}
