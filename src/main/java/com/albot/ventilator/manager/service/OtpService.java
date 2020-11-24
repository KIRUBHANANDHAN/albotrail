package com.albot.ventilator.manager.service;

import com.albot.ventilator.manager.model.web.OneTimePassword;


public interface OtpService {

    String getRandomNumber(String userName);

    OneTimePassword validateGivenOtp(OneTimePassword oneTimePassword);
}
