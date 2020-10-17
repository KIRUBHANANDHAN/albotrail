package com.albot.contentorchestrationservice.cassandra.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import java.math.BigInteger;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
@Table("user_credentials_details")
public class UserCredentialEntity {
    @Column("user_id")
    @PrimaryKeyColumn(name = "user_id", ordinal =  0, type = PrimaryKeyType.PARTITIONED)
    private UUID userId;
    @Column("user_name")
    @PrimaryKeyColumn(name = "user_name", ordinal =  0, type = PrimaryKeyType.PARTITIONED)
    private String userName;
    @Column("patient_id")
    private BigInteger patientId;
    @Column("encrypted_password")
    private String encryptedPassword;
    @Column("is_active_user")
    private Boolean isActiveUser;
    @Column("is_default_password")
    private Boolean isDefaultPassword;
    @Column("wrong_password_count")
    private Integer wrongPasswordCount;
    @Column("mobile_number")
    private BigInteger userMobileNumber;
}
