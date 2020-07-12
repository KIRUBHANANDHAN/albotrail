package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.dto.CallOut;
import java.util.List;


public interface ContentOrchestrationCallOutService {

    List<CallOut> getAllCallOut();

    CallOut getCallOut(final Integer handId);

    CallOut createCallOut(CallOut callOut);

    CallOut updateCallOut(CallOut callOut);

    CallOut deleteCallOut(final Integer handId);
}
