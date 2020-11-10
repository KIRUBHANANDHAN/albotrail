package com.albot.ventilator.manager.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
public class OneTimePassword {
    @ApiModelProperty(value = "Field is used for holding userName data as a String type.", required = true)
    private String userName;
    @ApiModelProperty(value = "Field is used for holding otpNumber data as a Integer type.", required = true)
    private Integer otpNumber;
}
