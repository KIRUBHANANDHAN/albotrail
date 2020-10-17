package com.albot.contentorchestrationservice.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
public class UserCredentialDetails {
    @ApiModelProperty(value = "Field is used for holding userName data as a String type.", required = true)
    private String userName;
    @ApiModelProperty(value = "Field is used for holding password data as a String type.", required = true)
    private String password;
    @ApiModelProperty(value = "Field is used for holding all authorities data as a Collection type.", required = true)
    private Collection<? extends GrantedAuthority> authorities;
}

