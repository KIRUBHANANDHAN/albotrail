package com.albot.contentorchestrationservice.cassandra.repository;


import com.albot.contentorchestrationservice.cassandra.entity.CallOutEntity;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.List;

public interface CallOutRepository  extends CassandraRepository<CallOutEntity, Integer> {

    public List<CallOutEntity> findAll();

    @AllowFiltering
    CallOutEntity findByhadmId(Integer hadmId);

    CallOutEntity insert(CallOutEntity callOutEntity);

    CallOutEntity save(CallOutEntity callOutEntity);
}
