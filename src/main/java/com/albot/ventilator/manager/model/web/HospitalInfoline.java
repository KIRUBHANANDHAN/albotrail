package com.albot.ventilator.manager.model.web;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
@JsonPropertyOrder
public class HospitalInfoline {
    @ApiModelProperty(value = "Field is used for holding Hospital data as a String type.", required = true)
    private String id;
    @ApiModelProperty(value = "Field is used for holding Hospital contact String type.", required = true)
    private String contact_info;

}
