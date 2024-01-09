package com.pns.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pns.spring.model.ResponseDTO;
import com.pns.spring.service.PathVariableService;


@RestController
public class PathVariableController {
	@Autowired
	PathVariableService service;
	
	@GetMapping("get/{id}")
	public ResponseEntity<ResponseDTO> getMethodName(@PathVariable("id") int id) {
		return service.getEmployee(id);
	}	
}
