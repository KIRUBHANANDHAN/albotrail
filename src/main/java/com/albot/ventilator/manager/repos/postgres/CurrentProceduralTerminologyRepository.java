package com.albot.ventilator.manager.repos.postgres;

import com.albot.ventilator.manager.model.CurrentProceduralTerminologyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrentProceduralTerminologyRepository extends JpaRepository<CurrentProceduralTerminologyEntity, Integer> {

    List<CurrentProceduralTerminologyEntity> findAll();

    CurrentProceduralTerminologyEntity findByRowId(Integer findByRowId);

    //CurrentProceduralTerminologyEntity insert(CurrentProceduralTerminologyEntity cpt);

    CurrentProceduralTerminologyEntity save(CurrentProceduralTerminologyEntity cpt);
}
