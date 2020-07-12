package com.albot.contentorchestrationservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.hateoas.server.core.Relation;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
@Relation(value = "CallOut", collectionRelation = "CallOut")
public class CallOut {
    @ApiModelProperty("It's rowId as a Integer type.")
    private Integer rowId;
    @ApiModelProperty("It's subjectId as a Integer type.")
    private Integer subjectId;
    @ApiModelProperty("It's hadmId as a Integer type.")
    private Integer hadmId;
    @ApiModelProperty("It's submitWardId as a Integer type.")
    private Integer submitWardId;
    @ApiModelProperty("It's submitCareUnit as a Integer type.")
    private String submitCareUnit;
    @ApiModelProperty("It's Integer as a Integer type.")
    private Integer currWardId;
    @ApiModelProperty("It's currCareUnit as a String type.")
    private String currCareUnit;
    @ApiModelProperty("It's callOutWardId as a Integer type.")
    private Integer callOutWardId;
    @ApiModelProperty("It's callOutService as a Integer type.")
    private String callOutService;
    @ApiModelProperty("It's requestTele as a Integer type.")
    private Integer requestTele;
    @ApiModelProperty("It's requestResp as a Integer type.")
    private Integer requestResp;
    @ApiModelProperty("It's requestCdIff as a Integer type.")
    private Integer requestCdIff;
    @ApiModelProperty("It's requestMrsa as a Integer type.")
    private Integer requestMrsa;
    @ApiModelProperty("It's requestVre as a Integer type.")
    private Integer requestVre;
    @ApiModelProperty("It's callOutStatus as a String type.")
    private String callOutStatus;
    @ApiModelProperty("It's callOutOutcome as a Integer type.")
    private String callOutOutcome;
    @ApiModelProperty("It's disChargeWardId as a Integer type.")
    private Integer disChargeWardId;
    @ApiModelProperty("It's acknowledgeStatus as a Integer type.")
    private String acknowledgeStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("It's createTime as a Date type.")
    private Date createTime;
    @ApiModelProperty("It's updateTime as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    @ApiModelProperty("It's acknowledgeTime as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date acknowledgeTime;
    @ApiModelProperty("It's outComeTime as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date outComeTime;
    @ApiModelProperty("It's firstReservationTime as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date firstReservationTime;
    @ApiModelProperty("It's currentReservationTime as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date currentReservationTime;
}
