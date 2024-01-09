package com.pns.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.pns.spring.ConsumerService;
import com.pns.spring.model.CustomerDTO;
import com.pns.spring.model.ResponseDTO;

@RestController
public class ConsumerController {
	@Autowired
	ConsumerService service;
	
	@PostMapping("save")
	public ResponseEntity<ResponseDTO> postSaveCustomer(
			@RequestBody CustomerDTO customer, @RequestHeader HttpHeaders headers){
		return service.saveCustomer(customer, headers);
	}
}
