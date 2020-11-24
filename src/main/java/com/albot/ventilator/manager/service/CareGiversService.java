package com.albot.ventilator.manager.service;

import com.albot.ventilator.manager.model.web.CareGivers;

import java.util.List;

public interface CareGiversService {

    List<CareGivers> getAllCareGivers();

    CareGivers getCareGiversByCgId(final Integer cgId);

    CareGivers createCareGivers(CareGivers careGivers);

    CareGivers updateCareGivers(CareGivers careGivers);

    void deleteCareGiversByCgId(final Integer cgid);
}
