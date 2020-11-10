package com.albot.ventilator.manager.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Table(name = "hospital_registration", uniqueConstraints = {@UniqueConstraint(columnNames = {"registration_num"})})
public class HospitalRegistrationEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_Id", columnDefinition = "bigserial", nullable = false, updatable = false)
    private BigInteger hospitalId;
    @Column(name = "name")
    private String name;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private AddressEntity address;
    @Column(name = "registration_num")
    private String registrationNum;
    @Column(name = "phone_number")
    private BigInteger phoneNumber;
    @OneToMany(mappedBy = "hospitalRegistrationEntity", cascade = CascadeType.ALL)
    private List<VentilatorMetadataEntity> ventilatorMetadataEntity;
}
