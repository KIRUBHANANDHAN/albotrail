package com.albot.contentorchestrationservice.cassandra.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
@UserDefinedType("INSURANCE")
public class InsuranceDetailsEntity {
    @Column("subscriber_id")
    private String subscriberId;
    @Column("subscriber_name")
    private String subscriberName;
    @Column("policy_no")
    private String policyNo;
    @Column("effective_date")
    private Date effectiveDate;
    @Column("insurance_company_name")
    private String insuranceCompanyName;
    @Column("name_of_insured_on_card")
    private String nameOfInsuredOnCard;
    @Column("relationship_to_patient")
    private String relationshipToPatient;
}
