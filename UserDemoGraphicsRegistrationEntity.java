package com.albot.contentorchestrationservice.postgres.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
@Entity
@TypeDef(name = "UserDemoGraphicsRegistrationEntity", typeClass = UserDemoGraphicsRegistrationEntity.class)
@Table(name = "user_demo_graphics_registration", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id"})})

public class UserDemoGraphicsRegistrationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", columnDefinition = "bigserial", nullable = false, updatable = false)
    private BigInteger userId;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "email_id")
    private String email;
    @Column(name = "phone_number")
    private BigInteger phoneNumber;
    @Column(name = "qualification")
    private String qualification;
    @Column(name = "hospital")
    private String hospital;
    @Column(name = "work_experience")
    private Integer workExperience;
    @Column(name = "specialty")
    private String specialty;
}
