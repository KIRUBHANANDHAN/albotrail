package io.albot.ventilator.manager.service;

import io.albot.ventilator.manager.model.web.OneTimePassword;


public interface OtpService {

    String getRandomNumber(String userName);

    OneTimePassword validateGivenOtp(OneTimePassword oneTimePassword);
}
