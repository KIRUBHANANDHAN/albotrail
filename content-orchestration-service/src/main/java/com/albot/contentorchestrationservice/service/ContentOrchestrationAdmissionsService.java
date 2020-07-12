package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.dto.Admissions;
import java.util.List;

public interface ContentOrchestrationAdmissionsService {

    List<Admissions> getAllAdmissions();

    Admissions getAdmissions(final Integer handId);

    Admissions createAdmissions(Admissions admissions);

    Admissions updateAdmissions(Admissions admissions);
}
