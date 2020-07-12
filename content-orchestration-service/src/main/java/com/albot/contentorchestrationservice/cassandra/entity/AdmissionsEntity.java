package com.albot.contentorchestrationservice.cassandra.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;
import java.util.Date;

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
@Table("ADMISSIONS")
public class AdmissionsEntity  {

    @Column("row_id")
    private Integer rowId;
    @Column("subject_id")
    @PrimaryKeyColumn(name = "subject_id", ordinal =  0, type = PrimaryKeyType.PARTITIONED)
    private Integer subjectId;
    @NonNull
    @Column("hadm_id")
    @PrimaryKeyColumn(name = "hadm_id", ordinal =  0, type = PrimaryKeyType.PARTITIONED)
    private Integer hadmId;
    @Column("admit_time")
    private Date  admitTime;
    @Column("disch_time")
    private Date  dischargeTime;
    @Column("death_time")
    private Date deathTime;
    @Column("admission_type")
    private String admissionType;
    @Column("admission_location")
    private String admissionLocation;
    @Column("discharge_location")
    private String dischargeLocation;
    @Column("insurance")
    private String insurance;
    @Column("language")
    private String language;
    @Column("religion")
    private String religion;
    @Column("marital_status")
    private String maritalStatus;
    @Column("ethni_city")
    private String ethniCity;
    @Column("edreg_time")
    private Date  edregTime;
    @Column("edout_time")
    private Date edoutTime;
    @Column("diagnosis")
    private String diagnosis;
    @Column("hospital_expire_flag")
    private Integer hospitalExpireFlag;
    @Column("has_chart_events_data")
    private Integer hasChartEventsData;
    @Column("status_flag")
    private Boolean statusFlag;
}
