package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.dto.CptEvent;
import java.util.List;

public interface ContentOrchestrationCptEventService {

    List<CptEvent> getAllCptEvent();

    CptEvent getCptEventBySubjectId(final Integer subjectId);

    CptEvent createCptEvent(CptEvent cptEvent);

    CptEvent updateCptEvent(CptEvent cptEvent);

    void deleteCptEventBySubjectId(final Integer subjectId);
}
