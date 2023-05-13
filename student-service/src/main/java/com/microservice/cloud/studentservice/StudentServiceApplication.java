package com.microservice.cloud.studentservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@ComponentScan({"com.microservice.cloud.studentservice.controller", "com.microservice.cloud.studentservice.service"})
@EntityScan("com.microservice.cloud.studentservice.entity")
@EnableJpaRepositories("com.microservice.cloud.studentservice.repo")
public class StudentServiceApplication {

	@Value("${address.service.url}")
	private String addressServiceUrl;

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

	@Bean
	public WebClient webClient() {
		WebClient webClient = WebClient.builder()
				.baseUrl(addressServiceUrl).build();

		return webClient;
	}
}
