package com.albot.ventilator.manager.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
@Entity
@TypeDef(name = "UserCredentialEntity", typeClass = UserCredentialEntity.class)
@Table(name = "user_credentials_details")
public class UserCredentialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigserial", nullable = false, updatable = false)
    private BigInteger id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "patient_id")
    private BigInteger patientId;
    @Column(name = "encrypted_password")
    private String encryptedPassword;
    @Column(name = "jwt")
    private String jwtToken;
    @Column(name = "last_login")
    private Date lastLogin;
    @Column(name = "is_active_user")
    private Boolean isActiveUser;
    @Column(name = "password_reset")
    private Boolean passwordReset;
    @Column(name = "is_default_password")
    private Boolean isDefaultPassword;
    @Column(name = "wrong_password_count")
    private Integer wrongPasswordCount;
    @Column(name = "mobile_number")
    private String userMobileNumber;
}
