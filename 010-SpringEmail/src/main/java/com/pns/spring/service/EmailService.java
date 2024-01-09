package com.pns.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	@Autowired
	JavaMailSenderImpl mailSender;
	
	public boolean sendEmail(String email) {
		boolean result = false;
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setText("Spring Email Test");
		message.setSubject("Test");
		try {
			mailSender.send(message);
			result = true;
		} catch (MailException e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}
}
