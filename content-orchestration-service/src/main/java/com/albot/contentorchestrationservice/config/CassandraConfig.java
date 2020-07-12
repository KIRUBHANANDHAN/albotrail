package com.albot.contentorchestrationservice.config;

import com.albot.contentorchestrationservice.cassandra.repository.AdmissionsRepository;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@PropertySource(value = {"classpath:application.yml"})
@ConfigurationProperties("spring.data.cassandra")
@EnableCassandraRepositories(basePackageClasses = AdmissionsRepository.class)
public class CassandraConfig extends AbstractCassandraConfiguration {
    @Override
    protected String getKeyspaceName() {
        return "hospital";
    }
    @Override
    protected String getLocalDataCenter() {
        return "datacenter1";
    }
}

