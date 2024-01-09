package com.pns.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pns.spring.model.CompanyDetailsDTO;
import com.pns.spring.model.CustomResponseDTO;
import com.pns.spring.services.CompanyService;

@RestController @RequestMapping("/rest")
public class RestAppController {
	@Autowired
	CompanyService companyServices;
	
	@GetMapping("/company/{id}")
	public ResponseEntity<CompanyDetailsDTO> getCompanyDetails(@PathVariable("id") int id) {
		return new ResponseEntity<>(companyServices.getCompanyDetails(id), HttpStatus.ACCEPTED);
	}
	@PostMapping("post")
	public ResponseEntity<CustomResponseDTO> postMethodName() {
		return companyServices.postEmployee();
	}	
}
