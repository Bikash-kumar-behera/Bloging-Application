package com.pns.spring.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pns.spring.model.Customer;
import com.pns.spring.model.ResponseDTO;

@Configuration
public class AppConfiguration {

	@Bean
	ResponseDTO<Customer> getResponseDTO() {
		return new ResponseDTO<>();
	}
}
