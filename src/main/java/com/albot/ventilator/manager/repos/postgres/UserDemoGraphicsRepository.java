package com.albot.ventilator.manager.repos.postgres;

import com.albot.ventilator.manager.model.dto.UserDemoGraphicsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserDemoGraphicsRepository extends JpaRepository<UserDemoGraphicsEntity, Long> {

    UserDemoGraphicsEntity findByUserId(Long id);
    @Query("SELECT t FROM UserDemoGraphicsEntity t WHERE t.userName = ?1 ")
    UserDemoGraphicsEntity findByUserName(String userName);

    UserDemoGraphicsEntity save(UserDemoGraphicsEntity userDemoGraphicsEntity);
}
