package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.cassandra.entity.UserCredentialEntity;
import com.albot.contentorchestrationservice.cassandra.repository.UserCredentialRepository;
import lombok.extern.slf4j.Slf4j;
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
public class UserDetailsServiceImp implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImp.class);

    private UserCredentialRepository userCredentialRepository;

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
}
