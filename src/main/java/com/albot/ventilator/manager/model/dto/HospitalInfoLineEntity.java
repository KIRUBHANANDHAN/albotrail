package com.albot.ventilator.manager.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.math.BigInteger;


@Data
@NoArgsConstructor
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
@Entity
@TypeDef(name = "HospitalInfoLineEntity", typeClass = HospitalInfoLineEntity.class)
@Table(name = "hospital_info_master", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class HospitalInfoLineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",  nullable = false, updatable = false)
    private Integer id;
    @Column(name = "HOSPNAME")
    private String Hosp_name;
    @Column(name = "CONTACT")
    private String contact_info;

}
