package com.albot.contentorchestrationservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode
public class Patients {
    @ApiModelProperty("Field is used for holding rowId data as a Integer type.")
    private Integer rowId;
    @ApiModelProperty(value = "Field is used for holding subjectId data as a Integer type.", required = true)
    private Integer subjectId;
    @ApiModelProperty("Field is used for holding gender data as a String type.")
    private String gender;
    @ApiModelProperty("Field is used for holding dateOfBirth date as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date dateOfBirth;
    @ApiModelProperty("Field is used for holding dateOfDeath date as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date dateOfDeath;
    @ApiModelProperty("Field is used for holding dateOfDeathHosp date as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date dateOfDeathHosp;
    @ApiModelProperty("Field is used for holding dateOfDeathSSN date as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date dateOfDeathSSN;
    @ApiModelProperty("Field is used for holding rowId data as a String type.")
    private String expireFlag;
}
