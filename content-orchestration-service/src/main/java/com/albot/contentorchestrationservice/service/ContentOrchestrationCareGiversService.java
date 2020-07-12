package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.dto.CareGivers;

import java.util.List;

public interface ContentOrchestrationCareGiversService {

    List<CareGivers> getAllCareGivers();

    CareGivers getCareGiversByCgId(final Integer cgId);

    CareGivers createCareGivers(CareGivers careGivers);

    CareGivers updateCareGivers(CareGivers careGivers);

     String deleteCareGiversByCgId(final Integer cgid);
}
