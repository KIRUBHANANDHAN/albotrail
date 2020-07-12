package com.albot.contentorchestrationservice.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.hateoas.server.core.Relation;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode
@Relation(value = "CareGivers", collectionRelation = "CareGivers")
public class CareGivers {
    @ApiModelProperty("It's rowId as a Integer type.")
    private Integer rowId;
    @ApiModelProperty("It's cgId as a Integer type.")
    private Integer cgId;
    @ApiModelProperty("It's label as a String type.")
    private String label;
    @ApiModelProperty("It's description as a String type.")
    private String description;
}
