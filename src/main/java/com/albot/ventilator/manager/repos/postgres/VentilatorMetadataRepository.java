package com.albot.ventilator.manager.repos.postgres;

import com.albot.ventilator.manager.model.HospitalRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VentilatorMetadataRepository extends JpaRepository<HospitalRegistrationEntity, UUID> {

}
