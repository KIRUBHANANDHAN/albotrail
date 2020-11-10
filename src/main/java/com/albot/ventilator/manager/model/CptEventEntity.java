package com.albot.ventilator.manager.model;

import lombok.*;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode
@Entity
@Table(name = "cpt_events")
@TypeDef(name = "CptEventEntity", typeClass = CptEventEntity.class)
public class CptEventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigserial", nullable = false, updatable = false)
    private BigInteger id;
    @Column(name = "row_id")
    private Integer rowId;
    @Column(name = "subject_id")
    private Integer subjectId;
    @Column(name = "hadm_id")
    private Integer hadmId;
    @Column(name = "cost_center")
    private String costCenter;
    @Column(name = "chart_date")
    private Date chartDate;
    @Column(name = "cpt_cd")
    private String cptCd;
    @Column(name = "cpt_number")
    private Integer cptNumber;
    @Column(name = "cpt_suffix")
    private String cptSuffix;
    @Column(name = "ticket_id_seq")
    private Integer ticketIdSeq;
    @Column(name = "section_header")
    private String sectionHeader;
    @Column(name = "sub_section_header")
    private String subSectionHeader;
    @Column(name = "description")
    private String description;
    @Column(name = "status_flag")
    private Boolean statusFlag;
}
