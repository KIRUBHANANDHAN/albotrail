package com.albot.contentorchestrationservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.hateoas.server.core.Relation;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
@Relation(value = "Admissions", collectionRelation = "Admissions")
public class Admissions implements Serializable {
    @ApiModelProperty("It's rowId as a Integer type.")
    private Integer rowId;
    @ApiModelProperty("It's subjectId as a Integer type.")
    private Integer subjectId;
    @NonNull
    @ApiModelProperty("It's hadmId as a Integer type.")
    private Integer hadmId;
    @ApiModelProperty("It's admitTime as a  Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date admitTime;
    @ApiModelProperty("It's dischargeTime as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date dischargeTime;
    @ApiModelProperty("It's deathTime as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date deathTime;
    @ApiModelProperty("It's admissionType as a String type.")
    private String admissionType;
    @ApiModelProperty("It's admissionLocation as a String type.")
    private String admissionLocation;
    @ApiModelProperty("It's dischargeLocation as a String type.")
    private String dischargeLocation;
    @ApiModelProperty("It's insurance as a String type.")
    private String insurance;
    @ApiModelProperty("It's language as a String type.")
    private String language;
    @ApiModelProperty("It's religion as a String type.")
    private String religion;
    @ApiModelProperty("It's maritalStatus as a String type.")
    private String maritalStatus;
    @ApiModelProperty("It's ethniCity as a String type.")
    private String ethniCity;
    @ApiModelProperty("It's edregTime as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date edregTime;
    @ApiModelProperty("It's edoutTime as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date edoutTime;
    @ApiModelProperty("It's diagnosis as a String type.")
    private String diagnosis;
    @ApiModelProperty("It's hospitalExpireFlag as a Integer type.")
    private Integer hospitalExpireFlag;
    @ApiModelProperty("It's hasChartEventsData as a Integer type.")
    private Integer hasChartEventsData;
}
