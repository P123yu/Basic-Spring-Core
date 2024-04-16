package com.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBasicCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBasicCrudApplication.class, args);
	}

}
