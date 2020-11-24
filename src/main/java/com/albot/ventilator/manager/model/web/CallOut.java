package com.albot.ventilator.manager.model.web;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
public class CallOut {
    @ApiModelProperty("Field is used for holding rowId data as a Integer type.")
    private Integer rowId;
    @ApiModelProperty(value = "Field is used for holding subjectId data as a Integer type.", required = true)
    private Integer subjectId;
    @ApiModelProperty(value = "Field is used for holding hadmId data as a Integer type.", required = true)
    private Integer hadmId;
    @ApiModelProperty("Field is used for holding submitWardId data as a Integer type.")
    private Integer submitWardId;
    @ApiModelProperty("Field is used for holding submitCareUnit data as a Integer type.")
    private String submitCareUnit;
    @ApiModelProperty("Field is used for holding Integer data as a Integer type.")
    private Integer currWardId;
    @ApiModelProperty("Field is used for holding currCareUnit data as a String type.")
    private String currCareUnit;
    @ApiModelProperty("Field is used for holding callOutWardId data as a Integer type.")
    private Integer callOutWardId;
    @ApiModelProperty("Field is used for holding callOutService data as a Integer type.")
    private String callOutService;
    @ApiModelProperty("Field is used for holding requestTele data as a Integer type.")
    private Integer requestTele;
    @ApiModelProperty("Field is used for holding requestResp data as a Integer type.")
    private Integer requestResp;
    @ApiModelProperty("Field is used for holding requestCdIff data as a Integer type.")
    private Integer requestCdIff;
    @ApiModelProperty("Field is used for holding requestMrsa data as a Integer type.")
    private Integer requestMrsa;
    @ApiModelProperty("Field is used for holding requestVre data as a Integer type.")
    private Integer requestVre;
    @ApiModelProperty("Field is used for holding callOutStatus data as a String type.")
    private String callOutStatus;
    @ApiModelProperty("Field is used for holding callOutOutcome data as a Integer type.")
    private String callOutOutcome;
    @ApiModelProperty("Field is used for holding disChargeWardId data as a Integer type.")
    private Integer disChargeWardId;
    @ApiModelProperty("Field is used for holding acknowledgeStatus data as a Integer type.")
    private String acknowledgeStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("Field is used for holding createTime date as a Date type.")
    private Date createTime;
    @ApiModelProperty("Field is used for holding updateTime date as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    @ApiModelProperty("Field is used for holding acknowledgeTime date as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date acknowledgeTime;
    @ApiModelProperty("Field is used for holding outComeTime date as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date outComeTime;
    @ApiModelProperty("Field is used for holding firstReservationTime date as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date firstReservationTime;
    @ApiModelProperty("Field is used for holding currentReservationTime date as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date currentReservationTime;
}
