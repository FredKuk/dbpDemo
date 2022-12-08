package com.dbp.demo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Demo01Application {
	public static void main(String[] args) {
		SpringApplication.run(Demo01Application.class, args);
	}
}
