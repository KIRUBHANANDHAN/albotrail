package io.albot.ventilator.manager.service.impl;

import io.albot.ventilator.manager.model.dto.HospitalRegistrationEntity;
import io.albot.ventilator.manager.model.dto.UserCredentialEntity;
import io.albot.ventilator.manager.model.dto.UserDemoGraphicsEntity;
import io.albot.ventilator.manager.model.web.UserDemoGraphics;
import io.albot.ventilator.manager.model.web.UserDemoGraphicsRegistration;
import io.albot.ventilator.manager.repos.postgres.UserCredentialRepository;
import io.albot.ventilator.manager.repos.postgres.UserDemoGraphicsRepository;
import io.albot.ventilator.manager.service.UserDemoGraphicsService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDemoGraphicsImp implements UserDemoGraphicsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDemoGraphicsImp.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserDemoGraphicsRepository userDemoGraphicsRepository;

    @Autowired
    UserCredentialRepository credentialRepository;

    @Autowired
    public UserDemoGraphicsImp(UserDemoGraphicsRepository userDemoGraphicsRepository) {
        this.userDemoGraphicsRepository = userDemoGraphicsRepository;
    }

    @Override
    public UserDemoGraphics getByUserName(String userName) {
        UserDemoGraphicsEntity userDemoGraphicsEntity =
                userDemoGraphicsRepository.findByUserName(userName);
        return convertToUserDemoGraphics(userDemoGraphicsEntity);
    }

    @Override
    public UserDemoGraphicsRegistration saveUserRegistration(UserDemoGraphicsRegistration req) {
        UserCredentialEntity cred = new UserCredentialEntity();
        cred.setUserName(req.getUsername());
        cred.setEncryptedPassword(bCryptPasswordEncoder.encode(req.getPassword()));
        cred.setUserMobileNumber(req.getPhoneNumber());
        cred.setIsActiveUser(true);
        credentialRepository.save(cred);
        UserDemoGraphicsEntity userDemoGraphicsEntity = new UserDemoGraphicsEntity();
        userDemoGraphicsEntity.setUserName(req.getUsername());
        userDemoGraphicsEntity.setName(req.getName());
        userDemoGraphicsEntity.setEmail(req.getEmail());
        userDemoGraphicsEntity.setGender(req.getGender());
        userDemoGraphicsEntity.setPhoneNumber(req.getPhoneNumber());
        userDemoGraphicsEntity.setQualification(req.getQualification());
        userDemoGraphicsEntity.setSpecialty(req.getSpecialty());
        userDemoGraphicsEntity.setWorkExperience(req.getWorkExperience());
        userDemoGraphicsEntity.setRegistration(req.getRegistration());
        userDemoGraphicsEntity.setUserCredentialEntity(cred);
        HospitalRegistrationEntity hosp = new HospitalRegistrationEntity();
        hosp.setHospitalId(Long.parseLong(req.getHosp_id()));
        userDemoGraphicsEntity.setHospitalRegistrationEntity(hosp);
        userDemoGraphicsRepository.save(userDemoGraphicsEntity);


        return convertToUserDemoGraphicsReg(userDemoGraphicsRepository.findByUserName(req.getUsername()));
    }

    @Override
    public UserDemoGraphicsRegistration updateUserDemoGraphicsRegistration(UserDemoGraphicsRegistration userDemoGraphics) {
        UserDemoGraphicsEntity userDemoGraphicsEntity = userDemoGraphicsRepository.findByUserId(userDemoGraphics.getId());
        if (Objects.isNull(userDemoGraphicsEntity)) {
            throw new UsernameNotFoundException("User " + userDemoGraphics.getName() + " not found for update.");
        }
        userDemoGraphicsEntity.setName(userDemoGraphics.getName());
        userDemoGraphicsEntity.setEmail(userDemoGraphics.getEmail());
        userDemoGraphicsEntity.setGender(userDemoGraphics.getGender());
        userDemoGraphicsEntity.setPhoneNumber(userDemoGraphics.getPhoneNumber());
        userDemoGraphicsEntity.setQualification(userDemoGraphics.getQualification());
        userDemoGraphicsEntity.setSpecialty(userDemoGraphics.getSpecialty());
        userDemoGraphicsEntity.setWorkExperience(userDemoGraphics.getWorkExperience());
        credentialRepository.updateMobile(userDemoGraphics.getPhoneNumber(), userDemoGraphicsEntity.getUserName());
        return convertToUserDemoGraphicsReg(userDemoGraphicsRepository
                .save(userDemoGraphicsEntity));
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
