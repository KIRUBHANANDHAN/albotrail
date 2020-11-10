package com.albot.ventilator.manager.repos.postgres;

import com.albot.ventilator.manager.model.UserCredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserCredentialRepository extends JpaRepository<UserCredentialEntity, Integer> {

    UserCredentialEntity getByUserName(String userName);

    UserCredentialEntity save(UserCredentialEntity userCredentialEntity);
}
