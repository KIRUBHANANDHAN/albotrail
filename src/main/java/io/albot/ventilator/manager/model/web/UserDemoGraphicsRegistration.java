package io.albot.ventilator.manager.model.web;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigInteger;


@Data

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
@JsonPropertyOrder
public class UserDemoGraphicsRegistration {

    @ApiModelProperty(value = "Field is used for holding id data as a Long type.", required = true)
    private Long id;
    @ApiModelProperty(value = "Field is used for holding userName data as a String type.", required = true)
    private String name;
    @ApiModelProperty(value = "Field is used for holding emailId data as a String type.", required = true)
    private String email;
    @ApiModelProperty(value = "Field is used for holding gender data as a boolean type.")
    private String gender;
    @ApiModelProperty(value = "Field is used for holding userPhoneNumber data as a BigInteger type.")
    private String phoneNumber;
    @ApiModelProperty(value = "Field is used for holding userQualification data as a String type.")
    private String qualification;
    @ApiModelProperty(value = "Field is used for holding workExperience data as a Integer type.")
    private Integer workExperience;
    @ApiModelProperty(value = "Field is used for holding specialty data as a String type.")
    private String specialty;
    @ApiModelProperty(value = "Field is used for holding password data as a String type.")
    private String password;
    @ApiModelProperty(value = "Field is used for holding username data as a String type.")
    private String username;
    @ApiModelProperty(value = "Field is used for holding registration data as a String type.")
    private String registration;

}
