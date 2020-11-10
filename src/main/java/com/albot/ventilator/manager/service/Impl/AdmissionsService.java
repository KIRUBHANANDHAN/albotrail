package com.albot.ventilator.manager.service.Impl;

import com.albot.ventilator.manager.model.Admissions;

import java.util.List;

public interface AdmissionsService {

    List<Admissions> getAllAdmissions();

    Admissions getAdmissionsByhadmId(final Integer hadmId);

    Admissions createAdmissions(Admissions admissions);

    Admissions updateAdmissions(Admissions admissions);

    void deleteAdmissionsByhadmId(final Integer hadmId);
}
