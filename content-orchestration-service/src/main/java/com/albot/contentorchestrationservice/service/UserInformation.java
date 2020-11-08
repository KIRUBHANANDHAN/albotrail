package com.albot.contentorchestrationservice.service;

import com.albot.contentorchestrationservice.model.UserInformationDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserInformation  extends UserDetailsService {
    //UserInformationDetails getUserInfo(String userName);
}
