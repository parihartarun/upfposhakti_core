package com.upfpo.app;

import java.util.Properties;


import com.upfpo.app.service.FPOGuidelineServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
@EnableJpaRepositories
public class UpFPOApplication  {

	/*@Autowired
	@Qualifier("javasampleapproachMailSender")
	public MailSender mailSender;*/



	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}


	public static void main(String[] args) {
		SpringApplication.run(UpFPOApplication.class, args);
	}




	/*@Override
	public void run(String... arg0) throws Exception {

		String from = "rahul.pande@neosoftmail.com";
		String to = "rahul.pande@neosoftmail.com";
		String subject = "JavaMailSender";
		String body = "Just-Testing!";
	}

	@Override
	public void run(String... arg) throws Exception {
		circularsService.deleteAll();
		circularsService.init();

	}*/

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
