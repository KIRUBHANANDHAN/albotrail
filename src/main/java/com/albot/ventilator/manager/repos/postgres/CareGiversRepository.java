package com.albot.ventilator.manager.repos.postgres;

import com.albot.ventilator.manager.model.CareGiversEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CareGiversRepository extends JpaRepository<CareGiversEntity, Integer> {

    List<CareGiversEntity> findAll();

    CareGiversEntity findBycgId(Integer cgId);

    //CareGiversEntity insert(CareGiversEntity careGiversEntity);

    CareGiversEntity save(CareGiversEntity careGiversEntity);

}
