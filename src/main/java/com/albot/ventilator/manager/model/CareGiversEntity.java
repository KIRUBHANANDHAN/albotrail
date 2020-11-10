package com.albot.ventilator.manager.model;

import lombok.*;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode
@Entity
@Table(name = "CAREGIVERS", uniqueConstraints = {@UniqueConstraint(columnNames = {"row_id"})})
@TypeDef(name = "CareGiversEntity", typeClass = CareGiversEntity.class)
public class CareGiversEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigserial", nullable = false, updatable = false)
    private BigInteger id;
    @Column(name = "row_id")
    private Integer rowId;
    @Column(name = "cgid")
    private Integer cgId;
    @Column(name = "label")
    private String label;
    @Column(name = "description")
    private String description;
    @Column(name = "status_flag")
    private Boolean statusFlag;
}
