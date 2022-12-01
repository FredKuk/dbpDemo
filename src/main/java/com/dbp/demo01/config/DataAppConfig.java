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
    @ConfigurationProperties("spring.datasource.jaden")
    public DataSourceProperties jadenDataSourceProperties(){
        return new DataSourceProperties();
    }
    
    @Bean
    public DataSource jadenDataSource(){
        return jadenDataSourceProperties()
            .initializeDataSourceBuilder()
            .type(HikariDataSource.class)
            .build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.jay")
    public DataSourceProperties jayDataSourceProperties(){
        return new DataSourceProperties();
    }
    
    @Bean
    public DataSource jayDataSource(){
        return jadenDataSourceProperties()
            .initializeDataSourceBuilder()
            .type(HikariDataSource.class)
            .build();
    }
    @Bean
    @ConfigurationProperties("spring.datasource.metal")
    public DataSourceProperties metalDataSourceProperties(){
        return new DataSourceProperties();
    }
    
    @Bean
    public DataSource metalDataSource(){
        return jadenDataSourceProperties()
            .initializeDataSourceBuilder()
            .type(HikariDataSource.class)
            .build();
    }
    @Bean
    @ConfigurationProperties("spring.datasource.tony")
    public DataSourceProperties tonyDataSourceProperties(){
        return new DataSourceProperties();
    }
    
    @Bean
    public DataSource tonyDataSource(){
        return jadenDataSourceProperties()
            .initializeDataSourceBuilder()
            .type(HikariDataSource.class)
            .build();
    }
}
