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
public class AuthenticationRequest implements Serializable {
    @ApiModelProperty(value = "Field is used for holding userName data as a String type.", required = true)
    private String username;
    @ApiModelProperty(value = "Field is used for holding password data as a String type.", required = true)
    private String password;
}


