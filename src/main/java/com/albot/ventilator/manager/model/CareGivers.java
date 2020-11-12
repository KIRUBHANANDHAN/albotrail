package com.albot.ventilator.manager.model;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode
public class CareGivers {
    @ApiModelProperty("Field is used for holding rowId data as a Integer type.")
    private Integer rowId;
    @ApiModelProperty(value = "Field is used for holding cgId date as a Integer type.", required = true)
    private Integer cgId;
    @ApiModelProperty("Field is used for holding label date as a String type.")
    private String label;
    @ApiModelProperty("Field is used for holding description date as a String type.")
    private String description;
}
