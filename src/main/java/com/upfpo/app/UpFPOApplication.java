package com.upfpo.app;

import java.util.Properties;

<<<<<<< HEAD
import com.upfpo.app.service.CircularsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
=======
>>>>>>> 11eec8db0b7631bb1e9af844d510dacd69cb659e
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

<<<<<<< HEAD
import javax.annotation.Resource;
import java.util.Properties;

=======
>>>>>>> 11eec8db0b7631bb1e9af844d510dacd69cb659e
@SpringBootApplication
@EnableJpaRepositories
public class UpFPOApplication implements CommandLineRunner {

<<<<<<< HEAD
	/*@Autowired
	@Qualifier("javasampleapproachMailSender")
	public MailSender mailSender;*/

	@Resource
	CircularsServiceImpl circularsService;

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

=======
>>>>>>> 11eec8db0b7631bb1e9af844d510dacd69cb659e
	public static void main(String[] args) {
		SpringApplication.run(UpFPOApplication.class, args);
	}

<<<<<<< HEAD


	/*@Override
	public void run(String... arg0) throws Exception {

		String from = "rahul.pande@neosoftmail.com";
		String to = "rahul.pande@neosoftmail.com";
		String subject = "JavaMailSender";
		String body = "Just-Testing!";
	}*/

	@Override
	public void run(String... arg) throws Exception {
		circularsService.deleteAll();
		circularsService.init();
	}

=======
>>>>>>> 11eec8db0b7631bb1e9af844d510dacd69cb659e

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
