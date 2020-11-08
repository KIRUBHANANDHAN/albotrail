package com.albot.contentorchestrationservice.postgres.repository;

import com.albot.contentorchestrationservice.postgres.entity.UserDemoGraphicsEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDemoGraphicsRepository extends JpaRepository<UserDemoGraphicsEntity, String> {

    UserDemoGraphicsEntity findAllByName(String userName);

    UserDemoGraphicsEntity save(UserDemoGraphicsEntity userDemoGraphicsEntity);
}
