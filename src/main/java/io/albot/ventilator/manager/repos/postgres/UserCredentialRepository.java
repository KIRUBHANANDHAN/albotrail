package io.albot.ventilator.manager.repos.postgres;

import io.albot.ventilator.manager.model.dto.UserCredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface UserCredentialRepository extends JpaRepository<UserCredentialEntity, Integer> {

    UserCredentialEntity getByUserName(String userName);

    UserCredentialEntity save(UserCredentialEntity userCredentialEntity);
    @Transactional
    @Modifying
    @Query("UPDATE UserCredentialEntity t SET t.userMobileNumber=?1 WHERE t.userName = ?2 ")
    void updateMobile(String Mobile, String username);
}
