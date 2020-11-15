package com.albot.ventilator.manager.service.impl;

import com.albot.ventilator.manager.model.web.UserDemoGraphics;
import com.albot.ventilator.manager.model.dto.UserDemoGraphicsEntity;
import com.albot.ventilator.manager.model.web.UserDemoGraphicsRegistration;
import com.albot.ventilator.manager.repos.postgres.UserDemoGraphicsRepository;
import com.albot.ventilator.manager.service.UserDemoGraphicsService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDemoGraphicsImp implements UserDemoGraphicsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDemoGraphicsImp.class);

    @Autowired
    private ModelMapper modelMapper;
    private final UserDemoGraphicsRepository userDemoGraphicsRepository;

    @Autowired
    public UserDemoGraphicsImp(UserDemoGraphicsRepository userDemoGraphicsRepository) {
        this.userDemoGraphicsRepository = userDemoGraphicsRepository;
    }

    @Override
    public UserDemoGraphics getByUserName(String userName) {
        UserDemoGraphicsEntity userDemoGraphicsEntity =
                userDemoGraphicsRepository.findAllByName(userName);
        return convertToUserDemoGraphics(userDemoGraphicsEntity);
    }

    @Override
    public UserDemoGraphicsRegistration saveUserDemoGraphicsRegistration(UserDemoGraphicsRegistration userDemoGraphicsReg) {
        return convertToUserDemoGraphicsReg(
                userDemoGraphicsRepository.
                        save(convertToUserDemoGraphicsRegEntity(userDemoGraphicsReg)));
    }

    private UserDemoGraphics convertToUserDemoGraphics(UserDemoGraphicsEntity userDemoGraphicsEntity) {
        return modelMapper
                .map(userDemoGraphicsEntity, UserDemoGraphics.class);
    }

    private UserDemoGraphicsRegistration convertToUserDemoGraphicsReg(UserDemoGraphicsEntity userDemoGraphicsReg) {
        return modelMapper
                .map(userDemoGraphicsReg, UserDemoGraphicsRegistration.class);
    }

    private UserDemoGraphicsEntity convertToUserDemoGraphicsRegEntity(UserDemoGraphicsRegistration userDemoGraphicsRegistration) {
        return modelMapper
                .map(userDemoGraphicsRegistration, UserDemoGraphicsEntity.class);
    }
}
