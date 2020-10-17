package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.model.CareGivers;

import java.util.List;

public interface ContentOrchestrationCareGiversService {

    List<CareGivers> getAllCareGivers();

    CareGivers getCareGiversByCgId(final Integer cgId);

    CareGivers createCareGivers(CareGivers careGivers);

    CareGivers updateCareGivers(CareGivers careGivers);

     void deleteCareGiversByCgId(final Integer cgid);
}
