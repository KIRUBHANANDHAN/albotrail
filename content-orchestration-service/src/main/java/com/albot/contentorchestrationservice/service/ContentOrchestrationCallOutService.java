package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.dto.CallOut;
import java.util.List;


public interface ContentOrchestrationCallOutService {

    List<CallOut> getAllCallOut();

    CallOut getCallOutByhadmId(final Integer hadmId);

    CallOut createCallOut(CallOut callOut);

    CallOut updateCallOut(CallOut callOut);

    void deleteCallOutByhadmId(final Integer hadmId);
}
