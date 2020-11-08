package com.albot.contentorchestrationservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode
public class AuthenticationResponse implements Serializable {
    @ApiModelProperty(value = "Field is used for holding accessToken data as a String type.")
    private String accessToken;
    @ApiModelProperty(value = "Field is used for holding tokenType data as a String type.")
    private String tokenType;
    @ApiModelProperty(value = "Field is used for holding statusCode data as a String type.")
    private Integer statusCode;
}
