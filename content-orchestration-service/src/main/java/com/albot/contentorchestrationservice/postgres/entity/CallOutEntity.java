package com.albot.contentorchestrationservice.postgres.entity;

import lombok.*;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode
@Entity
@TypeDef(name = "CallOutEntity", typeClass = CallOutEntity.class)
@Table(name = "CALL_OUT", uniqueConstraints = {@UniqueConstraint(columnNames = {"row_id", "subject_id"})})
public class CallOutEntity {
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
    @Column(name = "submit_ward_id")
    private Integer submitWardId;
    @Column(name = "submit_care_unit")
    private String submitCareUnit;
    @Column(name = "curr_ward_id")
    private Integer currWardId;
    @Column(name = "curr_care_unit")
    private String currCareUnit;
    @Column(name = "call_out_ward_id")
    private Integer callOutWardId;
    @Column(name = "call_out_service")
    private String callOutService;
    @Column(name = "request_tele")
    private Integer requestTele;
    @Column(name = "request_resp")
    private Integer requestResp;
    @Column(name = "request_cd_iff")
    private Integer requestCdIff;
    @Column(name = "request_mrsa")
    private Integer requestMrsa;
    @Column(name = "request_vre")
    private Integer requestVre;
    @Column(name = "call_out_status")
    private String callOutStatus;
    @Column(name = "call_out_out_come")
    private String callOutOutcome;
    @Column(name = "discharge_ward_id")
    private Integer disChargeWardId;
    @Column(name = "acknowledge_status")
    private String acknowledgeStatus;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "acknowledge_time")
    private Date acknowledgeTime;
    @Column(name = "out_come_time")
    private Date outComeTime;
    @Column(name = "first_reservation_time")
    private Date firstReservationTime;
    @Column(name = "current_reservation_time")
    private Date currentReservationTime;
    @Column(name = "status_flag")
    private Boolean statusFlag;
}
