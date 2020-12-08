package com.albot.ventilator.manager.service;

import com.albot.ventilator.manager.model.web.HospitalRegistration;

public interface HospitalRegistrationService {

    HospitalRegistration createHospital(HospitalRegistration hospitalRegistration);

    String getContact(String hosp_id);
}
