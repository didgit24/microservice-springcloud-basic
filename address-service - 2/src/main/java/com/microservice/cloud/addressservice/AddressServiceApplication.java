package com.microservice.cloud.addressservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.microservice.cloud.addressservice.controller", "com.microservice.cloud.addressservice.service"})
@EntityScan("com.microservice.cloud.addressservice.entity")
@EnableJpaRepositories("com.microservice.cloud.addressservice.repo")
@EnableEurekaClient
public class AddressServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressServiceApplication.class, args);
	}

}
