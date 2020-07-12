package com.albot.contentorchestrationservice.cassandra.entity;

import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

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

    @Column("row_id")
    private Integer rowId;
    @Column("subject_id")
    @PrimaryKeyColumn(name = "subject_id", ordinal =  0, type = PrimaryKeyType.PARTITIONED)
    private Integer subjectId;
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
