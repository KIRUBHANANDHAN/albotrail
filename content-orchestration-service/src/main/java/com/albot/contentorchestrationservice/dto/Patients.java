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
    @ApiModelProperty("It's rowId as a Integer type.")
    private Integer rowId;
    @ApiModelProperty("It's subjectId as a Integer type.")
    private Integer subjectId;
    @ApiModelProperty("It's gender as a String type.")
    private String gender;
    @ApiModelProperty("It's dateOfBirth as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    @ApiModelProperty("It's dateOfDeath as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfDeath;
    @ApiModelProperty("It's dateOfDeathHosp as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfDeathHosp;
    @ApiModelProperty("It's dateOfDeathSSN as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfDeathSSN;
    @ApiModelProperty("It's rowId as a String type.")
    private String expireFlag;
}
