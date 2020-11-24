package com.albot.ventilator.manager.model.web;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode
public class PatientLoginView {
    @ApiModelProperty(value = "Field is used for holding patientId data as a Integer type.", required = true)
    private Integer patientId;
}
