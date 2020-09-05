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
@UserDefinedType("ADDRESS")
public class AddressEntity {
    @Column("street_address_one")
    private String streetAddressOne;
    @Column("street_address_two")
    private String streetAddressTwo;
    @Column("city")
    private String city;
    @Column("state")
    private String state;
    @Column("zip_code")
    private Integer zipCode;
    @Column("country")
    private String country;
}
