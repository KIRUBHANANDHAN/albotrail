package com.albot.contentorchestrationservice.postgres.repository;

import com.albot.contentorchestrationservice.postgres.entity.UserCredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigInteger;


public interface UserCredentialRepository extends JpaRepository<UserCredentialEntity, Integer> {

    UserCredentialEntity getByUserName(String userName);

    UserCredentialEntity save(UserCredentialEntity userCredentialEntity);
}
