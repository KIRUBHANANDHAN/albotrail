package com.albot.contentorchestrationservice.model;

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
public class Address {
    private String streetAddressOne;
    private String streetAddressTwo;
    private String city;
    private String state;
    private Integer zipCode;
    private String country;
}
