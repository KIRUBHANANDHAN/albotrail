package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.model.Patients;

import java.util.List;

public interface ContentOrchestrationPatientService {

    List<Patients> getAllPatients();

    Patients getByPatientId(final Integer patientId);

    Patients createPatients(Patients patients);

    Patients updatePatients(Patients patients);

    void deletePatientByPatientId(final Integer patientId);
}
