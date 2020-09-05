package com.albot.contentorchestrationservice.cassandra.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
@UserDefinedType("EMERGENCY_CONTACT")
public class EmergencyContactDetailsEntity {
    @Column("name")
    private String name;
    @Column("relationship_to_patient")
    private String relationshipToPatient;
    @Column("mobile_number")
    private String mobileNumber;
}
