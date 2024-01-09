package com.pns.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pns.spring.service.EmailService;

@RestController
public class EmailRestController {
	@Autowired
	private EmailService emailService;
	
	@GetMapping("email")
	public ResponseEntity<String> sendEmail(@RequestParam("email") String email) {
		String message = emailService.sendEmail(email)?"Mail sent successfully":"Can not send mail";
		return ResponseEntity.ok(message);
	}
	
}
