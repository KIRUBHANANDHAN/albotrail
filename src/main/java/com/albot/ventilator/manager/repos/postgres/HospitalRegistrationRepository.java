package com.albot.ventilator.manager.repos.postgres;

import com.albot.ventilator.manager.model.HospitalRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRegistrationRepository extends JpaRepository<HospitalRegistrationEntity, Long> {

    HospitalRegistrationEntity save(HospitalRegistrationEntity hospitalRegistrationEntity);

}
