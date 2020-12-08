package io.albot.ventilator.manager.model.web;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data

@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode
public class AuthenticationResponse implements Serializable {

    public AuthenticationResponse(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;

    }

    @ApiModelProperty(value = "Field is used for holding accessToken data as a String type.")
    private String accessToken;
    @ApiModelProperty(value = "Field is used for holding tokenType data as a String type.")
    private String tokenType;
    @ApiModelProperty(value = "Field is used for holding statusCode data as a String type.")
    private Integer statusCode;
    private String message;
}
