package com.albot.contentorchestrationservice.cassandra.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.math.BigInteger;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode
@Table("Patients")
public class PatientEntity {
    @Column("patient_id")
    @PrimaryKeyColumn(name = "patient_id", ordinal =  0, type = PrimaryKeyType.PARTITIONED)
    private Integer patientId;
    @Column("row_id")
    private Integer rowId;
    @Column("subject_id")
    @PrimaryKeyColumn(name = "subject_id", ordinal =  0, type = PrimaryKeyType.PARTITIONED)
    private Integer subjectId;
    @Column("patient_name")
    private String patientName;
    @Column("age")
    private Integer age;
    @Column("occupation")
    private String occupation;
    @Column("marital_status")
    private String maritalStatus;
    @Column("height")
    private Float height;
    @Column("weight")
    private Double weight;
    @Column("date_of_admit")
    private Date dateOfAdmit;
    @Column("mobile_number")
    private BigInteger mobileNumber;
    @Column("alternate_number")
    private BigInteger alternateNumber;
    @Column("email")
    private String email;
    @Frozen
    @Column("address")
    private AddressEntity address;
    @Frozen
    @Column("insurance_details")
    private InsuranceDetailsEntity insuranceDetails;
    @Frozen
    @Column("emergency_contact_details")
    private EmergencyContactDetailsEntity emergencyContactDetails;
    @Column("gender")
    private String gender;
    @Column("dob")
    private Date dateOfBirth;
    @Column("dod")
    private Date dateOfDeath;
    @Column("dod_hosp")
    private Date dateOfDeathHosp;
    @Column("dod_ssn")
    private Date dateOfDeathSSN;
    @Column("expire_flag")
    private String expireFlag;
    @Column("status_flag")
    private Boolean statusFlag;
}
