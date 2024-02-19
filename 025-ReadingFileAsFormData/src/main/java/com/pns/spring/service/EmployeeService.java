package com.pns.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pns.spring.model.Employee;
import com.pns.spring.model.EmployeeResponseDto;

@Service
public interface EmployeeService {
	EmployeeResponseDto addEmployeesToDatabase(List<Employee> employees);
}
