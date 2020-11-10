package com.albot.ventilator.manager.model;

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
public class InsuranceDetailsEntity {
    private String subscriberId;
    private String subscriberName;
    private String policyNo;
    private Date effectiveDate;
    private String insuranceCompanyName;
    private String nameOfInsuredOnCard;
    private String relationshipToPatient;
}
