package com.albot.ventilator.manager.service;

import com.albot.ventilator.manager.model.CptEvent;

import java.util.List;

public interface CptEventService {

    List<CptEvent> getAllCptEvent();

    CptEvent getCptEventBySubjectId(final Integer subjectId);

    CptEvent createCptEvent(CptEvent cptEvent);

    CptEvent updateCptEvent(CptEvent cptEvent);

    void deleteCptEventBySubjectId(final Integer subjectId);
}
