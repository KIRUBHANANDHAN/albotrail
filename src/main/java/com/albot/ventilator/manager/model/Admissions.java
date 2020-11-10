package com.albot.ventilator.manager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
public class Admissions implements Serializable {
    @ApiModelProperty("Field is used for holding rowId data as a Integer type.")
    private Integer rowId;
    @ApiModelProperty("Field is used for holding subjectId data as a Integer type.")
    private Integer subjectId;
    @NonNull
    @ApiModelProperty(value = "Field is used for holding hadmId data as a Integer type.", required = true)
    private Integer hadmId;
    @ApiModelProperty("Field is used for holding admitTime date as a  Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date admitTime;
    @ApiModelProperty("Field is used for holding dischargeTime date as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date dischargeTime;
    @ApiModelProperty("Field is used for holding deathTime date as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date deathTime;
    @ApiModelProperty("Field is used for holding admissionType data as a String type.")
    private String admissionType;
    @ApiModelProperty("Field is used for holding admissionLocation data as a String type.")
    private String admissionLocation;
    @ApiModelProperty("Field is used for holding dischargeLocation data as a String type.")
    private String dischargeLocation;
    @ApiModelProperty("Field is used for holding insurance data as a String type.")
    private String insurance;
    @ApiModelProperty("Field is used for holding language data as a String type.")
    private String language;
    @ApiModelProperty("Field is used for holding religion data as a String type.")
    private String religion;
    @ApiModelProperty("Field is used for holding maritalStatus data as a String type.")
    private String maritalStatus;
    @ApiModelProperty("Field is used for holding ethniCity  data as a String type.")
    private String ethniCity;
    @ApiModelProperty("Field is used for holding edregTime date as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date edregTime;
    @ApiModelProperty("Field is used for holding edoutTime date as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date edoutTime;
    @ApiModelProperty("Field is used for holding diagnosis data as a String type.")
    private String diagnosis;
    @ApiModelProperty("Field is used for holding hospitalExpireFlag data as a Integer type.")
    private Integer hospitalExpireFlag;
    @ApiModelProperty("Field is used for holding hasChartEventsData data as a Integer type.")
    private Integer hasChartEventsData;
}
