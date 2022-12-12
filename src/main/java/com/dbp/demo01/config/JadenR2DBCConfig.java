package com.dbp.demo01.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;

@Configuration
@EnableR2dbcAuditing
@EnableR2dbcRepositories (basePackages = "com.dbp.demo01.repository.webflux_jaden")
public class JadenR2DBCConfig{

    public ConnectionFactory mysqlConnectionFactory() {
        ConnectionFactory connectionFactory = ConnectionFactories.get(
            "r2dbcs:mysql://jaden:jaden@192.168.0.28:3306/JADEN");
        return connectionFactory;
    }
}
