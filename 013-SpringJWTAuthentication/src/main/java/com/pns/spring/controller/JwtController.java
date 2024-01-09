package com.pns.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pns.spring.model.AuthRequestDTO;
import com.pns.spring.service.JwtUtilService;

@RestController
public class JwtController {
	@Autowired
	JwtUtilService jwtUtil;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@GetMapping("/auth/secure")
	public String getAuthenticatedPage() {
		return "Authenticated";
	}
	
	@PostMapping("/auth/token")
	public String getMethodName(@RequestBody AuthRequestDTO auth) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getUserName(), auth.getUserPass()));
		} catch (Exception e) {
			throw new RuntimeException("Invalid UserName/Password");
		}
		return jwtUtil.generateToken(auth.getUserName());
	}
}
