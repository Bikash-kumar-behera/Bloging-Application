package com.pns.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pns.spring.model.CustomResponseDTO;
import com.pns.spring.model.EmployeeDTO;
import com.pns.spring.service.EmployeeService;



@RestController
@RequestMapping("/project3")
public class RestAPPController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/")
	public ResponseEntity<String> homePage() {
		return ResponseEntity.ok("Welcome to Project-3");
	}
	@PostMapping(value = "/save",consumes = "application/json",produces = "application/json")
	public ResponseEntity<CustomResponseDTO<EmployeeDTO>> storeEmployee(@RequestBody EmployeeDTO employee) {
		return employeeService.saveEmployee(employee);
	}
	@GetMapping(value = "/get/{id}",produces = "application/json")
	public ResponseEntity<CustomResponseDTO<EmployeeDTO>> getEmployee(@PathVariable Integer id) {
		return employeeService.searchEmployee(id);
	}
	@GetMapping(value = "/delete/{id}",produces = "application/json")
	public ResponseEntity<CustomResponseDTO<EmployeeDTO>> removeEmployee(@PathVariable Integer id) {
		return employeeService.deleteEmployee(id);
	}
	@GetMapping("/all")
	public ResponseEntity<CustomResponseDTO<List<EmployeeDTO>>> getAllEmployee() {
		return employeeService.getAll();
	}
	
}
