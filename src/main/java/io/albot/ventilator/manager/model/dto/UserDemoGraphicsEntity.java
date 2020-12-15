package io.albot.ventilator.manager.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
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
    private String phoneNumber;
    @Column(name = "qualification")
    private String qualification;
    @Column(name = "work_experience")
    private Integer workExperience;
    @Column(name = "specialty")
    private String specialty;
    @Column(name = "registration")
    private String registration;
    @Column(name = "profile_image")
    private String profileImg;
    @OneToMany(mappedBy = "userDemoGraphicsEntity")
    @EqualsAndHashCode.Exclude
    private Set<PatientEntity> patientEntity;

    @OneToOne
    @JoinColumn(name = "hospital_Id")
    private HospitalRegistrationEntity hospitalRegistrationEntity;

    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private UserCredentialEntity userCredentialEntity;


}
