package com.albot.contentorchestrationservice.postgres.repository;

import com.albot.contentorchestrationservice.postgres.entity.ElasticSearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElasticSearchRepository extends JpaRepository<ElasticSearchEntity, Integer> {

    ElasticSearchEntity save(ElasticSearchEntity elasticSearchEntity);
}
