package com.pns.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pns.spring.service.EmployeeService;
import com.pns.spring.service.impl.EmployeeServiceImpl;

@Configuration
public class ApplicationConfiguration {
	
	@Bean
	EmployeeService getEmployeeService() {
		return new EmployeeServiceImpl();
	}
}
