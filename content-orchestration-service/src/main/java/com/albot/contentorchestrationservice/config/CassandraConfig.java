package com.albot.contentorchestrationservice.config;

import com.albot.contentorchestrationservice.cassandra.repository.AdmissionsRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@PropertySource(value = {"classpath:application.yml"})
@EnableCassandraRepositories(basePackageClasses = AdmissionsRepository.class)
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${spring.data.cassandra.keyspace-name}")
    private String keySpaceName;

    @Value("${spring.data.cassandra.local-datacenter}")
    private String localDataCenter;

    @Override
    protected String getKeyspaceName() {
        return keySpaceName;
    }

    @Override
    protected String getLocalDataCenter() {
        return localDataCenter;
    }
}

