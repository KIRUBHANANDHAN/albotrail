package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.model.Patients;

import java.util.List;

public interface ContentOrchestrationPatientService {

    List<Patients> getAllPatients();

    Patients getBySubjectId(final Integer subjectId);

    Patients createPatients(Patients patients);

    Patients updatePatients(Patients patients);

    void deletePatientsBySubjectId(final Integer subjectId);
}
