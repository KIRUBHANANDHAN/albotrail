package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.model.UserDemoGraphics;
import com.albot.contentorchestrationservice.model.UserDemoGraphicsRegistration;


public interface UserDemoGraphicsService {

    UserDemoGraphics getByUserName(String userName);

    UserDemoGraphicsRegistration saveUserDemoGraphicsRegistration(UserDemoGraphicsRegistration userDemoGraphics);
}
