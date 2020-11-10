package com.albot.ventilator.manager.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
public class EmergencyContactDetailsEntity {
    // @Column(name = "emergencyName")
    private String emergencyName;
    // @Column(name = "relationshipToPatient")
    private String relationshipToPatient;
    // @Column(name = "mobileNumber")
    private String mobileNumber;
}
