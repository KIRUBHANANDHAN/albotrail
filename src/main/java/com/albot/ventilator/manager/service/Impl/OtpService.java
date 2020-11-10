package com.albot.ventilator.manager.service.Impl;

import com.albot.ventilator.manager.model.OneTimePassword;


public interface OtpService {

    String getRandomNumber(String userName);

    OneTimePassword validateGivenOtp(OneTimePassword oneTimePassword);
}
