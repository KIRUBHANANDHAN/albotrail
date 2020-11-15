package com.albot.ventilator.manager.model.web;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
public class EmergencyContactDetails {
    private String name;
    private String relationshipToPatient;
    private BigInteger mobileNumber;
}
