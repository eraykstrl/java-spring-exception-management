package com.eraykosterelioglu.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EntityScan(basePackages = "com.eraykosterelioglu")
@EnableJpaRepositories(basePackages = "com.eraykosterelioglu")
@ComponentScan(basePackages = "com.eraykosterelioglu")
@SpringBootApplication(scanBasePackages = "com.eraykosterelioglu")
public class ExceptionManagementStarter{

	public static void main(String[] args) {
		SpringApplication.run(ExceptionManagementStarter.class, args);
	}

}
