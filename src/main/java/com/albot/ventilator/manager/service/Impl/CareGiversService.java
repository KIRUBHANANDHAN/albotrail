package com.albot.ventilator.manager.service.Impl;

import com.albot.ventilator.manager.model.CareGivers;

import java.util.List;

public interface CareGiversService {

    List<CareGivers> getAllCareGivers();

    CareGivers getCareGiversByCgId(final Integer cgId);

    CareGivers createCareGivers(CareGivers careGivers);

    CareGivers updateCareGivers(CareGivers careGivers);

    void deleteCareGiversByCgId(final Integer cgid);
}
