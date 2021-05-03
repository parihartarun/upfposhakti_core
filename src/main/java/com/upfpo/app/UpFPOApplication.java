package com.upfpo.app;

import java.util.Properties;

import com.upfpo.app.controller.InputSupplierMachineryController;
import com.upfpo.app.properties.FileStorageProperties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


@SpringBootApplication
@EnableJpaRepositories
@EnableConfigurationProperties({FileStorageProperties.class})
public class UpFPOApplication extends SpringBootServletInitializer {

	private static final Logger LOG = LogManager.getLogger(UpFPOApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UpFPOApplication.class, args);
	}

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);

		mailSender.setUsername("username");
		mailSender.setPassword("password");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}


	/*
	 * @Bean public PasswordEncoder getPasswordEncode() { PasswordEncoder
	 * passwordEncoder = new BCryptPasswordEncoder(); return passwordEncoder; }
	 */
}
