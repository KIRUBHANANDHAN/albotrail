package com.albot.contentorchestrationservice.postgres.entity;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
@Entity
@TypeDef(name = "VentilatorMetadataEntity", typeClass = VentilatorMetadataEntity.class)
@Table(name = "ventilator_metadata" ,uniqueConstraints = {@UniqueConstraint(columnNames = {"ip_address"})})
public class VentilatorMetadataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ventilator_id", columnDefinition = "bigserial", nullable = false, updatable = false)
    private Integer id;
    @Column(name = "ip_address")
    private BigInteger ipAddress;
    @Column(name = "ward")
    private Integer wardNumber;
    @Column(name = "floor_number")
    private Integer floorNumber;
    @ManyToOne
    @JoinColumn(referencedColumnName = "hospital_Id")
    private HospitalRegistrationEntity hospitalRegistrationEntity;
}
