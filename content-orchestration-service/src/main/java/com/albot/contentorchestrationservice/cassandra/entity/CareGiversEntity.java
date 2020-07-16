package com.albot.contentorchestrationservice.cassandra.entity;

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
@Table("CAREGIVERS")
public class CareGiversEntity {

    @Column("row_id")
    private Integer rowId;
    @PrimaryKeyColumn(name = "cgid", ordinal =  0, type = PrimaryKeyType.PARTITIONED)
    @Column("cgid")
    private Integer cgId;
    @Column("label")
    private String label;
    @Column("description")
    private String description;
    @Column("status_flag")
    private Boolean statusFlag;
}
