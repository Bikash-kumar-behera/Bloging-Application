package com.pns.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.pns.spring.model.CustomerDTO;
import com.pns.spring.model.ResponseDTO;
import com.pns.spring.service.ProducerService;

@RestController
public class ProducerController {
	@Autowired
	ProducerService service;

	@PostMapping("save")
	public ResponseEntity<ResponseDTO> postCustomer(@RequestBody CustomerDTO customer, @RequestHeader HttpHeaders headers) {
		List<String> userName = headers.get("username");
		List<String> passWord = headers.get("password");
		ResponseDTO response = new ResponseDTO();
		
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String message;
		HttpStatus status;
		if(userName==null || passWord==null) {
			message = "Credentials Not Provided";
			status = HttpStatus.FORBIDDEN;
		}else if (!userName.get(0).equals("itpl") || !passWord.get(0).equals("Itpl@1234")) {
			message = "Invalid Credentials";
			status = HttpStatus.FORBIDDEN;
		} else {
			response.setCustomerId(service.storeCustomer(customer));
			message = "Details Added Successfully";
			status = HttpStatus.OK;
		}
		response.setDescription(message);
		return new ResponseEntity<>(response, status);
	}

}
