package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.dto.Admissions;
import java.util.List;

public interface ContentOrchestrationAdmissionsService {

    List<Admissions> getAllAdmissions();

    Admissions getAdmissionsByhadmId(final Integer hadmId);

    Admissions createAdmissions(Admissions admissions);

    Admissions updateAdmissions(Admissions admissions);

    //Todo :- We are going remove return type in future
    String deleteAdmissionsByhadmId(final Integer hadmId);
}
