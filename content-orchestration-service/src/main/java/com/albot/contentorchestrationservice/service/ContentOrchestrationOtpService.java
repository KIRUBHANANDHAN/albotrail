package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.model.OneTimePassword;


public interface ContentOrchestrationOtpService {

    String getRandomNumber(String userName);

    OneTimePassword validateGivenOtp(OneTimePassword oneTimePassword);
}
