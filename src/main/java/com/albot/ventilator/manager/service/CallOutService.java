package com.albot.ventilator.manager.service;

import com.albot.ventilator.manager.model.CallOut;

import java.util.List;


public interface CallOutService {

    List<CallOut> getAllCallOut();

    CallOut getCallOutByhadmId(final Integer hadmId);

    CallOut createCallOut(CallOut callOut);

    CallOut updateCallOut(CallOut callOut);

    void deleteCallOutByhadmId(final Integer hadmId);
}
