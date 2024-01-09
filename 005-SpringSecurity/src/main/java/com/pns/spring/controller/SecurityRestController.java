package com.pns.spring.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/rest/auth")
public class SecurityRestController {
	@GetMapping("/home")
	public String getMethodName() {
		return new String("Welcome to Spring Security-HOME");
	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasAutho")
	public String adminLogin() {
		return new String("Welcome ADMIN");
	}
}
