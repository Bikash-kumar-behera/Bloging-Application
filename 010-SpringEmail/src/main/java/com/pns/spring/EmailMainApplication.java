package com.pns.spring;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import jakarta.mail.Session;

@SpringBootApplication
public class EmailMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailMainApplication.class, args);
	}
	
	@Bean
	JavaMailSenderImpl getJavaMailSenderImpl() {
				
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
//		mailSender.setPort(465);
		mailSender.setUsername("vssutmca2022");
		mailSender.setPassword("vuxujqmgbjritrid");
		
		Properties properties = new Properties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", "true");	
//		properties.put("mail.smtp.startssl.enable", true);	
		
		mailSender.setSession(Session.getInstance(properties));
		return mailSender;
	}

}
