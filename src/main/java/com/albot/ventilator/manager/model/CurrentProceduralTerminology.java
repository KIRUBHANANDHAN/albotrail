package com.albot.ventilator.manager.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode
public class CurrentProceduralTerminology {
    @ApiModelProperty("Field is used for holding rowId data as a Integer type.")
    private Integer rowId;
    @ApiModelProperty("Field is used for holding category data as a Integer type.")
    private Integer category;
    @ApiModelProperty("Field is used for holding sectionRange data as a String type.")
    private String sectionRange;
    @ApiModelProperty("Field is used for holding sectionHeader data as a String type.")
    private String sectionHeader;
    @ApiModelProperty("Field is used for holding subSectionRange data as a String type.")
    private String subSectionRange;
    @ApiModelProperty("Field is used for holding subSectionHeader data as a String type.")
    private String subSectionHeader;
    @ApiModelProperty("Field is used for holding codeSuffix data as a String type.")
    private String codeSuffix;
    @ApiModelProperty("Field is used for holding minCodeInSubSection data as a Integer type.")
    private Integer minCodeInSubSection;
    @ApiModelProperty("Field is used for holding maxCodeInSubSection data as a Integer type.")
    private Integer maxCodeInSubSection;
}
