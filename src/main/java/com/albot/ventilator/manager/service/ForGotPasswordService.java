package com.albot.ventilator.manager.service;

import com.albot.ventilator.manager.model.IdentifyByLoginUser;
import com.albot.ventilator.manager.model.ResetUserPassword;

public interface ForGotPasswordService {

    IdentifyByLoginUser getIdentifyByLoginUser(String userName);

    ResetUserPassword resetPassword(ResetUserPassword forGotPassword);
}
