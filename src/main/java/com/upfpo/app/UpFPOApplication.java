package com.upfpo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.*")
public class UpFPOApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpFPOApplication.class, args);
	}
}
