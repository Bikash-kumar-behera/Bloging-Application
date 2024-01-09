package com.pns.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pns.spring.model.Customer;
import com.pns.spring.model.RequestDTO;
import com.pns.spring.model.ResponseDTO;
import com.pns.spring.service.impl.CustomerServiceImpl;

import jakarta.validation.Valid;


@RestController
@Validated
public class CustomerController {
	@Autowired
	CustomerServiceImpl customerService;
	
	@PostMapping("post")
	public ResponseEntity<ResponseDTO<Customer>> post(@RequestBody @Valid RequestDTO requestDTO) {
		ResponseDTO<Customer> response = customerService.saveCustomer(requestDTO);
		return new ResponseEntity<>(response, response.getStatus());
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<ResponseDTO<Customer>> get(@PathVariable("id") Integer id){
		ResponseDTO<Customer> response = customerService.getCustomer(id);
		return new ResponseEntity<>(response, response.getStatus());
	}
	
	@PutMapping("put/{id}")
	public ResponseEntity<ResponseDTO<Customer>> put(@PathVariable Integer id, @RequestBody RequestDTO requestDTO) {
		ResponseDTO<Customer> response = customerService.updateCustomer(id, requestDTO);
		return new ResponseEntity<>(response, response.getStatus());
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<ResponseDTO<Customer>> delete(@PathVariable Integer id) {
		ResponseDTO<Customer> response = customerService.deleteCustomer(id);
		return new ResponseEntity<>(response, response.getStatus());
	}
	
}
