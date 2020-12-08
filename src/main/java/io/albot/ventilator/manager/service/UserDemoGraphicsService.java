package io.albot.ventilator.manager.service;

import io.albot.ventilator.manager.model.web.UserDemoGraphics;
import io.albot.ventilator.manager.model.web.UserDemoGraphicsRegistration;


public interface UserDemoGraphicsService {

    UserDemoGraphics getByUserName(String userName);

    UserDemoGraphicsRegistration saveUserDemoGraphicsRegistration(UserDemoGraphicsRegistration userDemoGraphics);

    UserDemoGraphicsRegistration updateUserDemoGraphicsRegistration(UserDemoGraphicsRegistration userDemoGraphics);
}
