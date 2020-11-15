package com.albot.ventilator.manager.model.web;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
public class ResetUserPassword {
    @NonNull
    @ApiModelProperty(value = "Field is used for holding userName data as a String type.", required = true)
    private String userName;
    @NonNull
    @ApiModelProperty(value = "Field is used for holding userName data as a String type.", required = true)
    private String newPassword;
}
