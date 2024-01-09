package com.pns.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class BasicAuthController {
	
	@GetMapping("admin")
	public String getAdmin() {
		return "Welcome Admin";
	}
	
	@GetMapping("user")
	public String getUser() {
		return "Welcome User";
	}
	
	@GetMapping("home")
	public String getHome() {
		return "Welcome Home";
	}
		
}
