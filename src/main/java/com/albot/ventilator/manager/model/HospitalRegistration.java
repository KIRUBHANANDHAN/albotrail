package com.albot.ventilator.manager.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
public class HospitalRegistration {
    //@ApiModelProperty(value = "Field is used for holding hospitalId data as a UUID type.", required = true)
    //private UUID hospitalId;
    @ApiModelProperty(value = "Field is used for holding hospitalName data as a String type.")
    private String name;
    @ApiModelProperty(value = "Field is used for holding hospitalAddress data as a Address type.")
    private Address address;
    @ApiModelProperty(value = "Field is used for holding registrationNum data as a String type.")
    private String registrationNum;
    @ApiModelProperty(value = "Field is used for holding phoneNumber data as a BigInteger type.")
    private BigInteger phoneNumber;
}
