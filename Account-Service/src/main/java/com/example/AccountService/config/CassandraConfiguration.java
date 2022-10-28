package com.example.AccountService.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraCqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.List;

@Configuration
@EnableCassandraRepositories
public class CassandraConfiguration extends AbstractCassandraConfiguration {
   // private static final String basePackages = "com.example.AccountService.entity";

    @Value("${spcloud.cassandra.contact.point}")
    private String contactPoint;

    @Value("${spcloud.cassandra.port}")
    private int port;

    @Value("${spcloud.cassandra.keyspace.name}")
    private String keyspaceName;

    @Value("${spcloud.cassandra.username}")
    private String username;

    @Value("${spcloud.cassandra.password}")
    private String password;



    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    protected String getContactPoints() {
        return contactPoint;
    }


    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }



    @Override
    public String[] getEntityBasePackages() {
        return new String[] {

                "com.example.AccountService.entity"
        };
    }
    @Override
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = super.cluster();
        cluster.setPassword(password);
        cluster.setUsername(username);
        return cluster;
    }


}
