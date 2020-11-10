package com.albot.ventilator.manager.repos.postgres;


import com.albot.ventilator.manager.model.CallOutEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CallOutRepository extends JpaRepository<CallOutEntity, Integer> {

    List<CallOutEntity> findAll();

    CallOutEntity findByhadmId(Integer hadmId);

    //CallOutEntity insert(CallOutEntity callOutEntity);

    CallOutEntity save(CallOutEntity callOutEntity);
}
