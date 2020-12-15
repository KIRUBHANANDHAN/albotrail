package io.albot.ventilator.manager.model.dto;


import io.albot.ventilator.manager.model.web.InsuranceDetails;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode
@Entity
@Table(name = "PATIENTS", uniqueConstraints = {@UniqueConstraint(columnNames = {"row_id", "subject_id"})})
@TypeDef(name = "PatientEntity", typeClass = PatientEntity.class)
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigserial", nullable = false, updatable = false)
    private Integer id;
    @Column(name = "row_id")
    private Integer rowId;
    @Column(name = "subject_id")
    private Integer subjectId;
    @Column(name = "patient_name")
    private String patientName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "occupation")
    private String occupation;
    @Column(name = "marital_status")
    private String maritalStatus;
    @Column(name = "height")
    private Float height;
    @Column(name = "weight")
    private Double weight;
    @Column(name = "date_of_admit")
    private Date dateOfAdmit;
    @Column(name = "mobile_number")
    private BigInteger mobileNumber;
    @Column(name = "alternate_number")
    private BigInteger alternateNumber;
    @Column(name = "email")
    private String email;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private AddressEntity address;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private InsuranceDetails insuranceDetails;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private EmergencyContactDetailsEntity emergencyContactDetails;
    @Column(name = "gender")
    private String gender;
    @Column(name = "dob")
    private Date dateOfBirth;
    @Column(name = "dod")
    private Date dateOfDeath;
    @Column(name = "dod_hosp")
    private Date dateOfDeathHosp;
    @Column(name = "dod_ssn")
    private Date dateOfDeathSSN;
    @Column(name = "expire_flag")
    private String expireFlag;
    @Column(name = "status_flag")
    private Boolean statusFlag;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable=false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude private UserDemoGraphicsEntity userDemoGraphicsEntity;
}
