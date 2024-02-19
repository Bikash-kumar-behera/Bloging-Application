package com.pns.spring.component;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartFile;

import com.pns.spring.model.Employee;
import com.pns.spring.model.EmployeeResponseDto;
import com.pns.spring.service.EmployeeService;
import com.pns.spring.service.OpenCsvService;

@Component
public class EmployeeComponent {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	OpenCsvService csvService;
		
	public EmployeeResponseDto saveFormDataToDatabase(MultipartFile file) {
		
		Optional<List<Employee>> optional = csvService.readAllEmployeesFromCsv(file);
		if(optional.isEmpty())
			return EmployeeResponseDto
					.builder()
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.message("Invalid data-format in the csv file")
					.build();
		List<Employee> employees = optional.get();
		EmployeeResponseDto response = EmployeeResponseDto
				.builder()
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.message("Atleast one row is required to read the data")
				.build();
		if(employees.size()!=0)
		 response = employeeService.addEmployeesToDatabase(employees);
		return response;
	}
}
