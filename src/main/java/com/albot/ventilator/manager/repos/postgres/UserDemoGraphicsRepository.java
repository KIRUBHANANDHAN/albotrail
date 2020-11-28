package com.albot.ventilator.manager.repos.postgres;

import com.albot.ventilator.manager.model.dto.UserDemoGraphicsEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserDemoGraphicsRepository extends JpaRepository<UserDemoGraphicsEntity, Long> {

    UserDemoGraphicsEntity findByUserId(Long id);

    UserDemoGraphicsEntity save(UserDemoGraphicsEntity userDemoGraphicsEntity);
}
