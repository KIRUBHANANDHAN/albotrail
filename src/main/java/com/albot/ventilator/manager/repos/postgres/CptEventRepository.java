package com.albot.ventilator.manager.repos.postgres;

import com.albot.ventilator.manager.model.CptEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CptEventRepository extends JpaRepository<CptEventEntity, Integer> {

    List<CptEventEntity> findAll();

    CptEventEntity findBySubjectId(Integer subjectId);

    //CptEventEntity insert(CptEventEntity cptEventEntity);

    CptEventEntity save(CptEventEntity cptEventEntity);
}
