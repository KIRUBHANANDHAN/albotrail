package com.albot.contentorchestrationservice.postgres.repository;

import com.albot.contentorchestrationservice.postgres.entity.CareGiversEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface CareGiversRepository extends JpaRepository<CareGiversEntity, Integer> {

     List<CareGiversEntity> findAll();

     CareGiversEntity findBycgId(Integer cgId);

     //CareGiversEntity insert(CareGiversEntity careGiversEntity);

     CareGiversEntity save(CareGiversEntity careGiversEntity);

}
