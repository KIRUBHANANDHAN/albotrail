package com.albot.ventilator.manager.service.Impl;

import com.albot.ventilator.manager.model.CurrentProceduralTerminology;

import java.util.List;

public interface CurrentProceduralTerminologyService {

    List<CurrentProceduralTerminology> getAllCurrentProceduralTerminology();

    CurrentProceduralTerminology getByRowId(final Integer rowId);

    CurrentProceduralTerminology createCurrentProceduralTerminology(CurrentProceduralTerminology cpt);

    CurrentProceduralTerminology updateCurrentProceduralTerminology(CurrentProceduralTerminology cpt);

    void deleteCurrentProceduralTerminologyByRowId(final Integer rowId);
}
