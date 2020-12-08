package io.albot.ventilator.manager.service;

import io.albot.ventilator.manager.model.web.Patients;

import java.util.List;

public interface PatientService {

    List<Patients> getAllPatients();

    Patients getByPatientId(final Integer patientId);

    Patients createPatients(Patients patients);

    Patients updatePatients(Patients patients);

    void deletePatientByPatientId(final Integer patientId);
}
