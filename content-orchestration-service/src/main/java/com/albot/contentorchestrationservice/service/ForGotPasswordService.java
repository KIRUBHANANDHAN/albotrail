package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.model.IdentifyByLoginUser;
import com.albot.contentorchestrationservice.model.ResetUserPassword;

public interface ForGotPasswordService {

    public IdentifyByLoginUser getIdentifyByLoginUser(IdentifyByLoginUser identifyByLoginUser);

    public ResetUserPassword resetPassword(ResetUserPassword forGotPassword);
}
