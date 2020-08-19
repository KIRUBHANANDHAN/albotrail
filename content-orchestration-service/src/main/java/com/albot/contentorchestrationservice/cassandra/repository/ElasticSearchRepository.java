package com.albot.contentorchestrationservice.cassandra.repository;

import com.albot.contentorchestrationservice.cassandra.entity.ElasticSearchEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface ElasticSearchRepository extends CassandraRepository<ElasticSearchEntity, Integer> {

    ElasticSearchEntity insert(ElasticSearchEntity elasticSearchEntity);
}
