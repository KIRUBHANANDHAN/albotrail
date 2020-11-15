package com.albot.ventilator.manager.service;

import com.albot.ventilator.manager.model.web.UserDemoGraphics;
import com.albot.ventilator.manager.model.web.UserDemoGraphicsRegistration;


public interface UserDemoGraphicsService {

    UserDemoGraphics getByUserName(String userName);

    UserDemoGraphicsRegistration saveUserDemoGraphicsRegistration(UserDemoGraphicsRegistration userDemoGraphics);
}
