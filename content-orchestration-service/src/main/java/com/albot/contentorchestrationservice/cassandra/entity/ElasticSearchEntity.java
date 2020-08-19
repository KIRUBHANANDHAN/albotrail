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
@Table("ELASTIC_SEARCH_FAILED_REQ")
public class ElasticSearchEntity {
    @Column("index_name")
    private String indexName;
    @Column("index_id")
    @PrimaryKeyColumn(name = "index_id", ordinal =  0, type = PrimaryKeyType.PARTITIONED)
    private String indexId;
    @Column("req_data")
    private String reqData;
    @Column("status")
    private String status;
}
