package com.pns.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pns.spring.entity.Employee;
import com.pns.spring.repo.EmployeeDao;
import com.pns.spring.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeRepository;
	
	@Override
	public List<Employee> fetchAllEmployeeDataFromDatabase() {
		return employeeRepository.findAll();
	}

}
