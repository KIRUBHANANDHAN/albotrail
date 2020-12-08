package io.albot.ventilator.manager.repos.postgres;

import io.albot.ventilator.manager.model.dto.HospitalRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HospitalRegistrationRepository extends JpaRepository<HospitalRegistrationEntity, Long> {

    HospitalRegistrationEntity save(HospitalRegistrationEntity hospitalRegistrationEntity);


    @Query("SELECT t.phoneNumber FROM HospitalRegistrationEntity t WHERE t.hospitalId = ?1")
    String findContact(int hosp_id);

}
