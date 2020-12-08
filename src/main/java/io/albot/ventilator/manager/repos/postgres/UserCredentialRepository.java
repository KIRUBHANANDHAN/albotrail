package io.albot.ventilator.manager.repos.postgres;

import io.albot.ventilator.manager.model.dto.UserCredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserCredentialRepository extends JpaRepository<UserCredentialEntity, Integer> {

    UserCredentialEntity getByUserName(String userName);

    UserCredentialEntity save(UserCredentialEntity userCredentialEntity);
}
