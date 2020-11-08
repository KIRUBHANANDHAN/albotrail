package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.model.OneTimePassword;


public interface OtpService {

    String getRandomNumber(String userName);

    OneTimePassword validateGivenOtp(OneTimePassword oneTimePassword);
}
