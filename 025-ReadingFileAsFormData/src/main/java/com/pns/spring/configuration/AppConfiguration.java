package com.pns.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pns.spring.service.EmployeeService;
import com.pns.spring.service.OpenCsvService;
import com.pns.spring.service.impl.EmployeeServiceImpl;
import com.pns.spring.service.impl.OpenCsvServiceImpl;

@Configuration
public class AppConfiguration {
	@Bean
	EmployeeService getEmployeeService() {
		return new EmployeeServiceImpl();
	}
	
	@Bean
	OpenCsvService getCsvService() {
		return new OpenCsvServiceImpl();
	}
}
