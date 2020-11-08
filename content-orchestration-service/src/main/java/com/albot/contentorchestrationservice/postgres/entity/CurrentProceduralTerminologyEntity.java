package com.albot.contentorchestrationservice.postgres.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

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
@JsonSerialize
@JsonDeserialize
@Entity
@Table(name = "d_cpt")
public class CurrentProceduralTerminologyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigserial", nullable = false, updatable = false)
    private BigInteger id;
    @Column(name = "row_id")
    private Integer rowId;
    @Column(name = "category")
    private Integer category;
    @Column(name = "section_range")
    private String sectionRange;
    @Column(name = "section_header")
    private String sectionHeader;
    @Column(name = "sub_section_range")
    private String subSectionRange;
    @Column(name = "sub_section_header")
    private String subSectionHeader;
    @Column(name = "code_suffix")
    private String codeSuffix;
    @Column(name = "min_code_in_sub_section")
    private Integer minCodeInSubSection;
    @Column(name = "max_code_in_sub_section")
    private Integer maxCodeInSubSection;
    @Column(name = "status_flag")
    private Boolean statusFlag;
}
