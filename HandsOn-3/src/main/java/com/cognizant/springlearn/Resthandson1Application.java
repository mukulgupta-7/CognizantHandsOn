package com.cognizant.springlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cognizant.*")
public class Resthandson1Application {

	public static void main(String[] args) {
		SpringApplication.run(Resthandson1Application.class, args);
	}

}
