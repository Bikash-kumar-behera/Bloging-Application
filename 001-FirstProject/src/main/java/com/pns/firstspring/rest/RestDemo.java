package com.pns.firstspring.rest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("rest/api")
public class RestDemo {
	@GetMapping("/first")
	public String getMethodName() {
		return "FIRST REST APPLICATION";
	}
	
}
