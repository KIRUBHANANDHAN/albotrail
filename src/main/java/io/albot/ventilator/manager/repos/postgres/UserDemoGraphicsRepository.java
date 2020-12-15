package io.albot.ventilator.manager.repos.postgres;

import io.albot.ventilator.manager.model.dto.UserDemoGraphicsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface UserDemoGraphicsRepository extends JpaRepository<UserDemoGraphicsEntity, Long> {

    UserDemoGraphicsEntity findByUserId(Long id);

    @Query("SELECT t FROM UserDemoGraphicsEntity t WHERE t.userName = ?1 ")
    UserDemoGraphicsEntity findByUserName(String userName);

    UserDemoGraphicsEntity save(UserDemoGraphicsEntity userDemoGraphicsEntity);

    @Modifying
    @Query("UPDATE UserDemoGraphicsEntity t SET t.profileImg =?1 WHERE t.userId = ?2 ")
    void updateProfileLink(String name, long id);
}
