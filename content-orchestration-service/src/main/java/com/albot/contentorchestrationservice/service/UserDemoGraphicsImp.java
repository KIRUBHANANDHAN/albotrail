package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.model.UserDemoGraphics;
import com.albot.contentorchestrationservice.model.UserDemoGraphicsRegistration;
import com.albot.contentorchestrationservice.postgres.entity.UserDemoGraphicsEntity;
import com.albot.contentorchestrationservice.postgres.repository.UserDemoGraphicsRepository;
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
    private UserDemoGraphicsRepository userDemoGraphicsRepository;

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
