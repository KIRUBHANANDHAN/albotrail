package com.albot.ventilator.manager.service.impl;

import com.albot.ventilator.manager.model.dto.UserCredentialEntity;
import com.albot.ventilator.manager.model.web.UserInformationDetails;
import com.albot.ventilator.manager.repos.postgres.UserCredentialRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
class UserDetailsServiceImp implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImp.class);

    @Autowired
    private ModelMapper modelMapper;

    private final UserCredentialRepository userCredentialRepository;

    @Autowired
    public UserDetailsServiceImp(UserCredentialRepository userCredentialRepository) {
        this.userCredentialRepository = userCredentialRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentialEntity userCredentialEntity = userCredentialRepository.getByUserName(username);
        if (userCredentialEntity == null) {
            logger.error("User not found with username: {}", username);
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new User(userCredentialEntity.getUserName(), userCredentialEntity.getEncryptedPassword(),
                new ArrayList<>());
    }
/*

    @Override
    public UserInformationDetails getUserInfo(String username) {
        UserCredentialEntity userCredentialEntity = userCredentialRepository.getByUserName(username);
        if (userCredentialEntity == null) {
            logger.error("User not found with username: {}", username);
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return convertToUserInformationDetails(userCredentialEntity);
    }
*/

    private UserInformationDetails convertToUserInformationDetails(UserCredentialEntity userCredentialEntity) {
        return modelMapper
                .map(userCredentialEntity, UserInformationDetails.class);
    }
}
