package com.ricardo.domingues.validpassword;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
				title = "Valid Password API",
				description = "This API validates receives a password and validates it",
				version = "1.0.0",
				contact = @Contact(name = "Ricardo Domingues", url = "", email = "ricardo.domingues27@gmail.com" )
		)
)
@SpringBootApplication
public class ValidPasswordApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ValidPasswordApplication.class, args);
	}

}
