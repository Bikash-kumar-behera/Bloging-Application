package com.pns.spring.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pns.spring.model.EmployeeDTO;

@Repository
public class EmployeeDAO {
	Map<Integer, EmployeeDTO> employeeMap;

	public EmployeeDAO() {
		employeeMap = new HashMap<>();
		employeeMap.put(1, new EmployeeDTO(1, "Harish", "Manager"));
		employeeMap.put(2, new EmployeeDTO(2, "Priyabrata", "Teacher"));
		employeeMap.put(3, new EmployeeDTO(3, "Sameer", "Clerk"));
		employeeMap.put(4, new EmployeeDTO(4, "Ramesh", "Peon"));
		employeeMap.put(5, new EmployeeDTO(5, "Chandan", "Student"));
	}

	public EmployeeDTO getEmployee(int id) {
		return employeeMap.get(id);
	}
}
