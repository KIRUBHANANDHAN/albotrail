package io.albot.ventilator.manager.service;

import io.albot.ventilator.manager.model.web.IdentifyByLoginUser;
import io.albot.ventilator.manager.model.web.ResetUserPassword;

public interface ForGotPasswordService {

    IdentifyByLoginUser getIdentifyByLoginUser(String userName);

    ResetUserPassword resetPassword(ResetUserPassword forGotPassword);
}
