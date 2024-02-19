package com.pns.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pns.spring.component.EmployeeComponent;
import com.pns.spring.model.EmployeeResponseDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("employee")
@Validated
@CrossOrigin(origins = "http://localhost:3000")

public class EmployeeRestController {
	
	@Autowired
	EmployeeComponent component;
	
	@PostMapping("save")
	public ResponseEntity<EmployeeResponseDto> saveEmployee(@Valid @RequestParam("file") MultipartFile file) {
		EmployeeResponseDto response = component.saveFormDataToDatabase(file);
		return new ResponseEntity<>(response,response.getStatus());
	}	
}
