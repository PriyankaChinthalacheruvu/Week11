package com.greatlearning.week9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class AdminMicroservice {

	public static void main(String[] args) {

		SpringApplication.run(AdminMicroservice.class, args);
	}

}
