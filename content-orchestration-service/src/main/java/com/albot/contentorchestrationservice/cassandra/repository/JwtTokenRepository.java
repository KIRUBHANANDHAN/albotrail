package com.albot.contentorchestrationservice.cassandra.repository;

import com.albot.contentorchestrationservice.cassandra.entity.JwtTokenEntity;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface JwtTokenRepository extends CassandraRepository<JwtTokenEntity, String> {

    @AllowFiltering
    JwtTokenEntity getJwtTokenByUserName(String name);

    JwtTokenEntity save(JwtTokenEntity jwtTokenEntity);
}
