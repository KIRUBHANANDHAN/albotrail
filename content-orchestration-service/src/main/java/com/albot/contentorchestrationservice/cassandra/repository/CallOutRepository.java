package com.albot.contentorchestrationservice.cassandra.repository;


import com.albot.contentorchestrationservice.cassandra.entity.CallOutEntity;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.List;

public interface CallOutRepository  extends CassandraRepository<CallOutEntity, Integer> {

    public List<CallOutEntity> findAll();

    @AllowFiltering
    public CallOutEntity findByhadmId(Integer hadmId);

    public CallOutEntity insert(CallOutEntity callOutEntity);

    public CallOutEntity save(CallOutEntity callOutEntity);
}
