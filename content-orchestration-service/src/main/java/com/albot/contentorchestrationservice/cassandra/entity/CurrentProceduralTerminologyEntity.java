package com.albot.contentorchestrationservice.cassandra.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

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
@Table("d_cpt")
public class CurrentProceduralTerminologyEntity {
    @Column("row_id")
    @PrimaryKeyColumn(name = "row_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private Integer rowId;
    @Column("category")
    private Integer category;
    @Column("section_range")
    private String sectionRange;
    @Column("section_header")
    private String sectionHeader;
    @Column("sub_section_range")
    private String subSectionRange;
    @Column("sub_section_header")
    private String subSectionHeader;
    @Column("code_suffix")
    private String codeSuffix;
    @Column("min_code_in_sub_section")
    private Integer minCodeInSubSection;
    @Column("max_code_in_sub_section")
    private Integer maxCodeInSubSection;
    @Column("status_flag")
    private Boolean statusFlag;
}
