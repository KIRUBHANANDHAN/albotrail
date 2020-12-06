package com.albot.ventilator.manager.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Set;


@Data
@NoArgsConstructor
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
@Entity
@TypeDef(name = "UserDemoGraphicsEntity", typeClass = UserDemoGraphicsEntity.class)
@Table(name = "user_demo_graphics")
public class UserDemoGraphicsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", columnDefinition = "bigserial", nullable = false, updatable = false)
    private long userId;
    @Column(name = "name")
    private String name;
    @Column(name = "user_name")
    private String userName;
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
    @OneToMany(mappedBy = "userDemoGraphicsEntity")
    @EqualsAndHashCode.Exclude private Set<PatientEntity> patientEntity;
}
