package com.albot.ventilator.manager.service;

import com.albot.ventilator.manager.model.Patients;

import java.util.List;

public interface PatientService {

    List<Patients> getAllPatients();

    Patients getByPatientId(final Integer patientId);

    Patients createPatients(Patients patients);

    Patients updatePatients(Patients patients);

    void deletePatientByPatientId(final Integer patientId);
}
