package io.albot.ventilator.manager.model.web;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data

@NoArgsConstructor
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
public class HospitalRegistration {
    @ApiModelProperty(value = "Field is used for holding hospitalName data as a String type.")
    private String name;
    @ApiModelProperty(value = "Field is used for holding hospitalAddress data as a Address type.")
    private Address address;
    @ApiModelProperty(value = "Field is used for holding registrationNum data as a String type.")
    private String registrationNum;
    @ApiModelProperty(value = "Field is used for holding phoneNumber data as a BigInteger type.")
    private BigInteger phoneNumber;
}
