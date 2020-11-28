package com.albot.ventilator.manager.service;

import com.albot.ventilator.manager.model.web.UserDemoGraphics;
import com.albot.ventilator.manager.model.web.UserDemoGraphicsRegistration;


public interface UserDemoGraphicsService {

    UserDemoGraphics getById(Long id);

    UserDemoGraphicsRegistration saveUserDemoGraphicsRegistration(UserDemoGraphicsRegistration userDemoGraphics);

    UserDemoGraphicsRegistration updateUserDemoGraphicsRegistration(UserDemoGraphicsRegistration userDemoGraphics);
}
