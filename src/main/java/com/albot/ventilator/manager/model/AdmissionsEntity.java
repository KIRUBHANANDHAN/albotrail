package com.albot.ventilator.manager.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
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
@JsonSerialize
@JsonDeserialize
@Entity
@TypeDef(name = "AdmissionsEntity", typeClass = AdmissionsEntity.class)
@Table(name = "ADMISSIONS", uniqueConstraints = {@UniqueConstraint(columnNames = {"hadm_id"})})
public class AdmissionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigserial", nullable = false, updatable = false)
    private BigInteger id;
    @Column(name = "row_id")
    private Integer rowId;
    @Column(name = "subject_id")
    private Integer subjectId;
    @Column(name = "hadm_id")
    private Integer hadmId;
    @Column(name = "admit_time")
    private Date admitTime;
    @Column(name = "disch_time")
    private Date dischargeTime;
    @Column(name = "death_time")
    private Date deathTime;
    @Column(name = "admission_type")
    private String admissionType;
    @Column(name = "admission_location")
    private String admissionLocation;
    @Column(name = "discharge_location")
    private String dischargeLocation;
    @Column(name = "insurance")
    private String insurance;
    @Column(name = "language")
    private String language;
    @Column(name = "religion")
    private String religion;
    @Column(name = "marital_status")
    private String maritalStatus;
    @Column(name = "ethni_city")
    private String ethniCity;
    @Column(name = "edreg_time")
    private Date edregTime;
    @Column(name = "edout_time")
    private Date edoutTime;
    @Column(name = "diagnosis")
    private String diagnosis;
    @Column(name = "hospital_expire_flag")
    private Integer hospitalExpireFlag;
    @Column(name = "has_chart_events_data")
    private Integer hasChartEventsData;
    @Column(name = "status_flag")
    private Boolean statusFlag;
}
