package com.albot.ventilator.manager.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode
@JsonSerialize
@JsonDeserialize
@Entity
@Table(name = "ELASTIC_SEARCH_FAILED_REQ")
public class ElasticSearchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigserial", nullable = false, updatable = false)
    private BigInteger id;
    @Column(name = "index_name")
    private String indexName;
    @Column(name = "index_id")
    private String indexId;
    @Column(name = "req_data")
    private String reqData;
    @Column(name = "status")
    private Boolean status;
}
