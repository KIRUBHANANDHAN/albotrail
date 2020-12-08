package io.albot.ventilator.manager.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data

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
