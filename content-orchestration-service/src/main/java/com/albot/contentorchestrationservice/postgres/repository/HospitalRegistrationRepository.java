package com.albot.contentorchestrationservice.postgres.repository;

import com.albot.contentorchestrationservice.postgres.entity.HospitalRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRegistrationRepository extends JpaRepository<HospitalRegistrationEntity, Long> {

    HospitalRegistrationEntity save(HospitalRegistrationEntity hospitalRegistrationEntity);

}
