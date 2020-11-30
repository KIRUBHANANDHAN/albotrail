package com.albot.ventilator.manager.service.impl;

import com.albot.ventilator.manager.configs.S3Config;
import com.albot.ventilator.manager.model.web.UserDemoGraphics;
import com.albot.ventilator.manager.model.dto.UserDemoGraphicsEntity;
import com.albot.ventilator.manager.model.web.UserDemoGraphicsRegistration;
import com.albot.ventilator.manager.repos.postgres.UserDemoGraphicsRepository;
import com.albot.ventilator.manager.service.UserDemoGraphicsService;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@Service
public class UserDemoGraphicsImp implements UserDemoGraphicsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDemoGraphicsImp.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private S3Config s3Config;

    private final UserDemoGraphicsRepository userDemoGraphicsRepository;

    @Autowired
    public UserDemoGraphicsImp(UserDemoGraphicsRepository userDemoGraphicsRepository) {
        this.userDemoGraphicsRepository = userDemoGraphicsRepository;
    }

    @Override
    public UserDemoGraphics getById(Long id) {
        UserDemoGraphicsEntity userDemoGraphicsEntity =
                userDemoGraphicsRepository.findByUserId(id);
        return convertToUserDemoGraphics(userDemoGraphicsEntity);
    }

    @Override
    public UserDemoGraphicsRegistration saveUserDemoGraphicsRegistration(UserDemoGraphicsRegistration userDemoGraphicsReg) {
        return convertToUserDemoGraphicsReg(
                userDemoGraphicsRepository.
                        save(convertToUserDemoGraphicsRegEntity(userDemoGraphicsReg)));
    }

    @Override
    public UserDemoGraphicsRegistration updateUserDemoGraphicsRegistration(UserDemoGraphicsRegistration userDemoGraphics) {
        UserDemoGraphicsEntity userDemoGraphicsEntity = userDemoGraphicsRepository.findByUserId(userDemoGraphics.getId());
        if (Objects.isNull(userDemoGraphicsEntity)) {
            throw new UsernameNotFoundException("User " + userDemoGraphics.getName() + " not found for update.");
        }
        userDemoGraphicsEntity.setUserId(userDemoGraphics.getId());
        userDemoGraphicsEntity.setName(userDemoGraphics.getName());
        userDemoGraphicsEntity.setEmail(userDemoGraphics.getEmail());
        userDemoGraphicsEntity.setGender(userDemoGraphics.getGender());
        userDemoGraphicsEntity.setPhoneNumber(userDemoGraphics.getPhoneNumber());
        userDemoGraphicsEntity.setQualification(userDemoGraphics.getQualification());
        userDemoGraphicsEntity.setSpecialty(userDemoGraphics.getSpecialty());
        userDemoGraphicsEntity.setHospital(userDemoGraphics.getHospital());
        userDemoGraphicsEntity.setWorkExperience(userDemoGraphics.getWorkExperience());
        return convertToUserDemoGraphicsReg(userDemoGraphicsRepository
                .save(userDemoGraphicsEntity));
    }


    @Override
    public String uploadUserProfileImage(MultipartFile imageFile) {
        try {
            byte[] userProfile = imageFile.getBytes();
            String fileName = imageFile.getOriginalFilename();
            s3Config.getS3Client().putObject(new PutObjectRequest(s3Config.getBucketName(), fileName, new File(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
