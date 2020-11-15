package com.albot.ventilator.manager.repos.postgres;

import com.albot.ventilator.manager.model.dto.ElasticSearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElasticSearchRepository extends JpaRepository<ElasticSearchEntity, Integer> {

    ElasticSearchEntity save(ElasticSearchEntity elasticSearchEntity);
}
