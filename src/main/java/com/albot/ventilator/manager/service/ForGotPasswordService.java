package com.albot.ventilator.manager.service;

import com.albot.ventilator.manager.model.web.IdentifyByLoginUser;
import com.albot.ventilator.manager.model.web.ResetUserPassword;

public interface ForGotPasswordService {

    IdentifyByLoginUser getIdentifyByLoginUser(String userName);

    ResetUserPassword resetPassword(ResetUserPassword forGotPassword);
}
