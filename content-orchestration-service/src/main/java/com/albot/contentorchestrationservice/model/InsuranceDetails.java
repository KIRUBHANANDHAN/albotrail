package com.albot.contentorchestrationservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;


import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
public class InsuranceDetails {
    private String subscriberId;
    private String subscriberName;
    private String groupNo;
    private Integer policyNo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date effectiveDate;
    private String insuranceCompanyName;
    private String nameOfInsuredOnCard;
    private String relationshipToPatient;
}
