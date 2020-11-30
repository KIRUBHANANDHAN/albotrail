package com.albot.ventilator.manager.service;

import com.albot.ventilator.manager.model.web.UserDemoGraphics;
import com.albot.ventilator.manager.model.web.UserDemoGraphicsRegistration;
import org.springframework.web.multipart.MultipartFile;


public interface UserDemoGraphicsService {

    UserDemoGraphics getById(Long id);

    UserDemoGraphicsRegistration saveUserDemoGraphicsRegistration(UserDemoGraphicsRegistration userDemoGraphics);

    UserDemoGraphicsRegistration updateUserDemoGraphicsRegistration(UserDemoGraphicsRegistration userDemoGraphics);

    String uploadUserProfileImage(MultipartFile image);
}
