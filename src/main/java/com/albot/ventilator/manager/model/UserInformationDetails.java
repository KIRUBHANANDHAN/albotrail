package com.albot.ventilator.manager.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.math.BigInteger;
import java.util.UUID;

@Data

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
@Builder
public class UserInformationDetails {
    @ApiModelProperty(value = "Field is used for holding userId data as a UUID type.", required = true)
    private UUID userId;
    @ApiModelProperty(value = "Field is used for holding userName data as a String type.", required = true)
    private String userName;
    @ApiModelProperty(value = "Field is used for holding patientId data as a BigInteger type.", required = true)
    private BigInteger patientId;
    @ApiModelProperty(value = "Field is used for holding encryptedPassword data as a String type.")
    private String encryptedPassword;
    @ApiModelProperty(value = "Field is used for holding isActiveUser data as a Boolean type.")
    private Boolean isActiveUser;
    @ApiModelProperty(value = "Field is used for holding isDefaultPassword data as a Boolean type.")
    private Boolean isDefaultPassword;
    @ApiModelProperty(value = "Field is used for holding wrongPasswordCount data as a Integer type.")
    private Integer wrongPasswordCount;
    @ApiModelProperty(value = "Field is used for holding userMobileNumber data as a String type.")
    private String userMobileNumber;
}

