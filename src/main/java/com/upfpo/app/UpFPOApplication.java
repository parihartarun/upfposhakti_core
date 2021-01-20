package com.upfpo.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class UpFPOApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpFPOApplication.class, args);
	}
}