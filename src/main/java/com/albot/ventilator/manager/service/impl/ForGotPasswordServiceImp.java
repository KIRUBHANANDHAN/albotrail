package com.albot.ventilator.manager.service.impl;

import com.albot.ventilator.manager.exceptions.InvalidUserCredentials;
import com.albot.ventilator.manager.exceptions.UserCredentialNotFound;
import com.albot.ventilator.manager.model.dto.UserCredentialEntity;
import com.albot.ventilator.manager.model.web.IdentifyByLoginUser;
import com.albot.ventilator.manager.model.web.ResetUserPassword;
import com.albot.ventilator.manager.repos.postgres.UserCredentialRepository;
import com.albot.ventilator.manager.service.ForGotPasswordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ForGotPasswordServiceImp implements ForGotPasswordService {
    private static final Logger logger = LoggerFactory.getLogger(ForGotPasswordServiceImp.class);
    private final UserCredentialRepository userCredentialRepository;

    public ForGotPasswordServiceImp(UserCredentialRepository userCredentialRepository) {
        this.userCredentialRepository = userCredentialRepository;
    }


    @Override
    public IdentifyByLoginUser getIdentifyByLoginUser(String userName) {
        UserCredentialEntity userCredentialEntity
                = userCredentialRepository
                .getByUserName(userName.toLowerCase());
        if (!Objects.isNull(userCredentialEntity)) {
            if (userCredentialEntity.getIsActiveUser().equals(Boolean.FALSE)) {
                logger.error("Found given IdentifyByLoginUser user {} is not active User ", userCredentialEntity.getUserName());
                throw new InvalidUserCredentials("Given User name " + userCredentialEntity.getUserName() + " not active User, Please contact IT admin ");
            }
            logger.info("Found IdentifyByLoginUser  user {}", userCredentialEntity.getUserName());
            IdentifyByLoginUser identifyByLoginUser1 = new IdentifyByLoginUser();
            identifyByLoginUser1.setUserName(userCredentialEntity.getUserName());
            identifyByLoginUser1.setUserMobileNum(userCredentialEntity.getUserMobileNumber());
            return identifyByLoginUser1;
        } else {
            logger.error("Given IdentifyByLoginUser user {} not found", userName);
            throw new UserCredentialNotFound("Given User name " + userName + " not found");
        }
    }

    @Override
    public ResetUserPassword resetPassword(ResetUserPassword resetUserPassword) {
        UserCredentialEntity userCredentialEntity =
                userCredentialRepository
                        .getByUserName(resetUserPassword.getUserName().toLowerCase());
        if (!Objects.isNull(userCredentialEntity)) {
            userCredentialEntity.setEncryptedPassword(resetUserPassword.getNewPassword());
            userCredentialRepository.save(userCredentialEntity);
            logger.info("Successfully reset password for given user {}", resetUserPassword.getUserName());
            return resetUserPassword;
        } else {
            logger.error("Given user not {} found for reset password", resetUserPassword.getUserName());
            throw new UserCredentialNotFound("Given user " + resetUserPassword.getUserName() + " not found for resting password");
        }
    }
}
