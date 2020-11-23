package com.albot.ventilator.manager.repos.postgres;

import com.albot.ventilator.manager.model.dto.HospitalInfoLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalInfoLineRepository extends JpaRepository<HospitalInfoLineEntity, Integer> {

    HospitalInfoLineEntity findByid(int hosp_id);
}
