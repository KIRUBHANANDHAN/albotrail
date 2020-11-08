package com.albot.contentorchestrationservice.postgres.repository;

import com.albot.contentorchestrationservice.postgres.entity.AdmissionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface AdmissionsRepository extends JpaRepository<AdmissionsEntity, Integer> {

    List<AdmissionsEntity> findAll();

    AdmissionsEntity findByhadmId(Integer hadmId);

    //AdmissionsEntity insert(AdmissionsEntity admissionsEntity);

    AdmissionsEntity save(AdmissionsEntity admissionsEntity);
}
