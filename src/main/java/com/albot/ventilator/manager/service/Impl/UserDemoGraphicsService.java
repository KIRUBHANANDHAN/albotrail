package com.albot.ventilator.manager.service.Impl;

import com.albot.ventilator.manager.model.UserDemoGraphics;
import com.albot.ventilator.manager.model.UserDemoGraphicsRegistration;


public interface UserDemoGraphicsService {

    UserDemoGraphics getByUserName(String userName);

    UserDemoGraphicsRegistration saveUserDemoGraphicsRegistration(UserDemoGraphicsRegistration userDemoGraphics);
}
