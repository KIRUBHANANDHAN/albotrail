package com.albot.ventilator.manager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode
public class CptEvent {
    @ApiModelProperty("Field is used for holding rowId data as a Integer type.")
    private Integer rowId;
    @ApiModelProperty("Field is used for holding subjectId data as a Integer type.")
    private Integer subjectId;
    @ApiModelProperty("Field is used for holding hadmId data as a Integer type.")
    private Integer hadmId;
    @ApiModelProperty("Field is used for holding costCenter data as a String type.")
    private String costCenter;
    @ApiModelProperty("Field is used for holding chartDate data as a Date type.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date chartDate;
    @ApiModelProperty("Field is used for holding cptCd data as a String type.")
    private String cptCd;
    @ApiModelProperty("Field is used for holding cptNumber data as a Integer type.")
    private Integer cptNumber;
    @ApiModelProperty("Field is used for holding cptSuffix data as a String type.")
    private String cptSuffix;
    @ApiModelProperty("Field is used for holding ticketIdSeq data as a Integer type.")
    private Integer ticketIdSeq;
    @ApiModelProperty("Field is used for holding sectionHeader data as a String type.")
    private String sectionHeader;
    @ApiModelProperty("Field is used for holding subSectionHeader data as a String type.")
    private String subSectionHeader;
    @ApiModelProperty("Field is used for holding description data as a String type.")
    private String description;
}
