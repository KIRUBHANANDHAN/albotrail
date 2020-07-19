package com.albot.contentorchestrationservice.cassandra.entity;

import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode
@Table("cpt_events")
public class CptEventEntity {
    @Column("row_id")
    private Integer rowId;
    @Column("subject_id")
    @PrimaryKeyColumn(name = "subject_id", ordinal =  0, type = PrimaryKeyType.PARTITIONED)
    private Integer subjectId;
    @Column("hadm_id")
    private Integer hadmId;
    @Column("cost_center")
    private String costCenter;
    @Column("chart_date")
    private Date chartDate;
    @Column("cpt_cd")
    private String cptCd;
    @Column("cpt_number")
    private Integer cptNumber;
    @Column("cpt_suffix")
    private String cptSuffix;
    @Column("ticket_id_seq")
    private Integer ticketIdSeq;
    @Column("section_header")
    private String sectionHeader;
    @Column("sub_section_header")
    private String subSectionHeader;
    @Column("description")
    private String description;
    @Column("status_flag")
    private Boolean statusFlag;
}
