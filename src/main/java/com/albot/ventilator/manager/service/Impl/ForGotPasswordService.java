package com.albot.ventilator.manager.service.Impl;

import com.albot.ventilator.manager.model.IdentifyByLoginUser;
import com.albot.ventilator.manager.model.ResetUserPassword;

public interface ForGotPasswordService {

    IdentifyByLoginUser getIdentifyByLoginUser(IdentifyByLoginUser identifyByLoginUser);

    ResetUserPassword resetPassword(ResetUserPassword forGotPassword);
}
