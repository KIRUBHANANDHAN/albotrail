package com.albot.contentorchestrationservice.cassandra.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
@UserDefinedType("jwt_token_management")
public class JwtTokenEntity {
    @Column("uuid")
    @PrimaryKeyColumn(name = "uuid", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID uuid;
    @Column("user_name")
    @PrimaryKeyColumn(name = "user_name", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private String userName;
    @Column("jwt_token")
    private String jwtToken;
    @Column("current_time")
    private Date currentTime;
}
