package com.dbp.demo01.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;


@Configuration
public class DataAppConfig {

    @Bean
    @ConfigurationProperties("spring.jay.datasource")
    public DataSourceProperties jayDataSourceProperties(){
        return new DataSourceProperties();
    }
    
    @Bean
    public DataSource jayDataSource(){
        return jayDataSourceProperties()
            .initializeDataSourceBuilder()
            .type(HikariDataSource.class)
            .build();
    }
    @Bean
    @ConfigurationProperties("spring.metal.datasource")
    public DataSourceProperties metalDataSourceProperties(){
        return new DataSourceProperties();
    }
    
    @Bean
    public DataSource metalDataSource(){
        return metalDataSourceProperties()
            .initializeDataSourceBuilder()
            .type(HikariDataSource.class)
            .build();
    }
    @Bean
    @ConfigurationProperties("spring.tony.datasource")
    public DataSourceProperties tonyDataSourceProperties(){
        return new DataSourceProperties();
    }
    
    @Bean
    public DataSource tonyDataSource(){
        return tonyDataSourceProperties()
            .initializeDataSourceBuilder()
            .type(HikariDataSource.class)
            .build();
    }
}
