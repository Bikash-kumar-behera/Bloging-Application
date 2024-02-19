package com.pns.spring.service;

import java.util.List;

import com.pns.spring.entity.Employee;

public interface EmployeeService {
	List<Employee> fetchAllEmployeeDataFromDatabase();
}
