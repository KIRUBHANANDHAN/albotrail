package com.albot.contentorchestrationservice.postgres.repository;

import com.albot.contentorchestrationservice.postgres.entity.HospitalRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VentilatorMetadataRepository extends JpaRepository<HospitalRegistrationEntity, UUID> {

}
