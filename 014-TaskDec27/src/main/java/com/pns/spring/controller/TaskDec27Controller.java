package com.pns.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pns.spring.model.CustomerDTO;
import com.pns.spring.model.GetCustomerRequestDTO;
import com.pns.spring.model.RequestDTO;
import com.pns.spring.model.ResponseDTO;
import com.pns.spring.service.impl.TaskDec27ServiceImpl;

import jakarta.validation.Valid;


@RestController
public class TaskDec27Controller {
	
	@Autowired
	TaskDec27ServiceImpl service;
	
	@Validated
	@PostMapping("save")
	public ResponseEntity<ResponseDTO<String>> saveCustomer(@Valid @RequestBody RequestDTO requestDTO) {
		HttpStatus status;
		ResponseDTO<String> responseDTO = new ResponseDTO<>();
		if(service.save(requestDTO)) {
			responseDTO.setMessage("Successfully saved to DB");
			status = HttpStatus.OK;
		} else {
			responseDTO.setMessage("Something went wrong");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(responseDTO, status);
	}
	
	@PostMapping("get")
	public ResponseEntity<ResponseDTO<CustomerDTO>> getCustomer(@Valid @RequestBody GetCustomerRequestDTO getRequest) {
		CustomerDTO customerDTO = service.getCustomer(getRequest);
		ResponseDTO<CustomerDTO> responseDTO = new ResponseDTO<>();
		HttpStatus status;
		if(customerDTO!=null)
		{
			responseDTO.setMessage("Customer fetched successfully");
			responseDTO.setT(customerDTO);
			status = HttpStatus.OK;
		} else {
			responseDTO.setMessage("No customer found");
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(responseDTO, status);
	}
	
}
