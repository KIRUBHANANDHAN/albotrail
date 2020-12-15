package io.albot.ventilator.manager.service;

import io.albot.ventilator.manager.model.web.HospitalRegistration;

import java.util.List;

public interface HospitalRegistrationService {

    HospitalRegistration createHospital(HospitalRegistration hospitalRegistration);

    String getContact(String hosp_id);
    List<HospitalRegistration> getAllHospitals();
}
