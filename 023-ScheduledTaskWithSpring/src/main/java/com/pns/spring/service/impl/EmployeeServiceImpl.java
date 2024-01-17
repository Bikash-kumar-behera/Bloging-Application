package com.pns.spring.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;

import com.pns.spring.entity.Employee;
import com.pns.spring.repo.EmployeeDao;
import com.pns.spring.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao employeeRepository;
	
	@Override
	public void fetchDataFromDatabaseAndWriteToCsv() {

		String headers[] = new String[] { "id", "first_name", "last_name", "email", "gender", "profession" };
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader(headers);

		List<Employee> employees = employeeRepository.findAll();

		try (Writer writer = new FileWriter(new File("src/main/resources/employee.csv"), false); 
				CSVPrinter printer = new CSVPrinter(writer, csvFormat);) {
			employees.forEach(employee->{
				try {
					printer.print(employee.getId());
					printer.print(employee.getFirstName());
					printer.print(employee.getLastName());
					printer.print(employee.getEmail());
					printer.print(employee.getGender());
					printer.print(employee.getProfession());
					printer.println();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
