package com.albot.contentorchestrationservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtConfig {

    @Value("${jwt_token.securityKey}")
    private String securityKey;
    @Value("${jwt_token.tokenExpireTime}")
    private Long tokenExpireTime;

    public String getSecurityKey() {
        return securityKey;
    }

    public Long getTokenExpireTime() {
        return tokenExpireTime;
    }
}
