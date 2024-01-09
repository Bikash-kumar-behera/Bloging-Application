package com.pns.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pns.spring.model.CardDTO;
import com.pns.spring.model.CustomerDTO;
import com.pns.spring.model.ResponseDTO;
import com.pns.spring.service.impl.OneToManyServiceImpl;


@RestController
public class OneToManyController {
	
	@Autowired
	OneToManyServiceImpl oneToManyServiceImpl;
	
	@PostMapping("post")
	public ResponseEntity<ResponseDTO<CustomerDTO>> postMethodName(@RequestBody CustomerDTO customerDTO) {
		ResponseDTO<CustomerDTO> response = oneToManyServiceImpl.saveCustomer(customerDTO);
		return new ResponseEntity<>(response, response.getStatus());
	}
	
	@GetMapping("get/{phone}")
	public ResponseEntity<ResponseDTO<List<CardDTO>>> getCards(@PathVariable("phone") long mobileNumber) {
		ResponseDTO<List<CardDTO>> response = oneToManyServiceImpl.getAllCards(mobileNumber);
		return new ResponseEntity<>(response,response.getStatus());
	}
	
	
}
