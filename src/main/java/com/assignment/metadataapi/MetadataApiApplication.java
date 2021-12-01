package com.assignment.metadataapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;


/*
Class: Metadata API server Application
Description: Main class to start the springboot application
Author:Prachi Gupta
 */

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Metadata API", version = "1.0", description = "Metadata API Server Application"))

public class MetadataApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetadataApiApplication.class, args);
	}

	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		return new MethodValidationPostProcessor();
	}
	@Bean
	public javax.validation.Validator localValidatorFactoryBean() {
		return new LocalValidatorFactoryBean();
	}
}
