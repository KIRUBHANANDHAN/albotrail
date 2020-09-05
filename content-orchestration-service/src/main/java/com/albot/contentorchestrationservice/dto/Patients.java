package com.albot.contentorchestrationservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.math.BigInteger;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode
public class Patients {
    @ApiModelProperty(value = "Field is used for holding patientId data as a Integer type.", required = true)
    private Integer patientId;
    @ApiModelProperty("Field is used for holding rowId data as a Integer type.")
    private Integer rowId;
    @ApiModelProperty(value = "Field is used for holding subjectId data as a Integer type.", required = true)
    private Integer subjectId;
    @ApiModelProperty(value = "Field is used for holding patientName data as a String type.")
    private String patientName;
    @ApiModelProperty(value = "Field is used for holding age data as a Integer type.")
    private Integer age;
    @ApiModelProperty(value = "Field is used for holding occupation data as a String type.")
    private String occupation;
    @ApiModelProperty(value = "Field is used for height occupation data as a Float type.")
    private Float height;
    @ApiModelProperty(value = "Field is used for weight occupation data as a Float type.")
    private Double weight;
    @ApiModelProperty(value = "Field is used for holding maritalStatus data as a String type.")
    private String maritalStatus;
    @ApiModelProperty(value = "Field is used for holding mobileNumber data as a BigInteger type.")
    private BigInteger mobileNumber;
    @ApiModelProperty(value = "Field is used for holding email data as a String type.")
    private String email;
    @ApiModelProperty(value = "Field is used for holding address data as a Address type.")
    private Address address;
    @ApiModelProperty(value = "Field is used for holding InsuranceDetails data as a InsuranceDetails type.")
    private InsuranceDetails insuranceDetails;
    @ApiModelProperty(value = "Field is used for holding EmergencyContactDetails data as a EmergencyContactDetails type.")
    private EmergencyContactDetails emergencyContactDetails;
    @ApiModelProperty("Field is used for holding gender data as a String type.")
    private String gender;
    @ApiModelProperty("Field is used for holding dateOfAdmit data as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date dateOfAdmit;
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
