package com.albot.contentorchestrationservice.cassandra.repository;

import com.albot.contentorchestrationservice.cassandra.entity.UserCredentialEntity;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import java.math.BigInteger;


public interface UserCredentialRepository extends CassandraRepository<UserCredentialEntity, Integer> {

    @AllowFiltering
    UserCredentialEntity getByUserName(String  userName);

    @AllowFiltering
    UserCredentialEntity getByPatientId(BigInteger  patientId);

    UserCredentialEntity save(UserCredentialEntity userCredentialEntity);
}
