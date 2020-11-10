package com.albot.ventilator.manager.repos.postgres;

import com.albot.ventilator.manager.model.UserDemoGraphicsEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDemoGraphicsRepository extends JpaRepository<UserDemoGraphicsEntity, String> {

    UserDemoGraphicsEntity findAllByName(String userName);

    UserDemoGraphicsEntity save(UserDemoGraphicsEntity userDemoGraphicsEntity);
}
