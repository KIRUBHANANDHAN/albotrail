package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.dto.CareGivers;

import java.util.List;

public interface ContentOrchestrationCareGiversService {

    List<CareGivers> getAllCareGivers();

    CareGivers getCareGivers(final Integer cgId);

    CareGivers createCareGivers(CareGivers callOut);

    CareGivers updateCareGivers(CareGivers callOut);

}
