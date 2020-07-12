package com.albot.contentorchestrationservice.cassandra.entity;

import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode
@Table("CALLOUT")
public class CallOutEntity {

    @Column("row_id")
    private Integer rowId;
    @Column("subject_id")
    private Integer subjectId;
    @Column("hadm_id")
    @PrimaryKeyColumn(name = "hadm_id", ordinal =  0, type = PrimaryKeyType.PARTITIONED)
    private Integer hadmId;
    @Column("submit_ward_id")
    private Integer submitWardId;
    @Column("submit_care_unit")
    private String submitCareUnit;
    @Column("curr_ward_id")
    private Integer currWardId;
    @Column("curr_care_unit")
    private String currCareUnit;
    @Column("call_out_ward_id")
    private Integer callOutWardId;
    @Column("call_out_service")
    private String callOutService;
    @Column("request_tele")
    private Integer requestTele;
    @Column("request_resp")
    private Integer requestResp;
    @Column("request_cd_iff")
    private Integer requestCdIff;
    @Column("request_mrsa")
    private Integer requestMrsa;
    @Column("request_vre")
    private Integer requestVre;
    @Column("call_out_status")
    private String callOutStatus;
    @Column("call_out_out_come")
    private String callOutOutcome;
    @Column("discharge_ward_id")
    private Integer disChargeWardId;
    @Column("acknowledge_status")
    private String acknowledgeStatus;
    @Column("create_time")
    private Date createTime;
    @Column("update_time")
    private Date updateTime;
    @Column("acknowledge_time")
    private Date acknowledgeTime;
    @Column("out_come_time")
    private Date outComeTime;
    @Column("first_reservation_time")
    private Date firstReservationTime;
    @Column("current_reservation_time")
    private Date currentReservationTime;
}
