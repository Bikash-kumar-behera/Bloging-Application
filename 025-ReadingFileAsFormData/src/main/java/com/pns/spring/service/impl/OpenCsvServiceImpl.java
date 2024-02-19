package com.pns.spring.service.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.pns.spring.model.Employee;
import com.pns.spring.service.OpenCsvService;

public class OpenCsvServiceImpl implements OpenCsvService {

	@Override
	public Optional<List<Employee>> readAllEmployeesFromCsv(MultipartFile inputFile) {
		if (inputFile.isEmpty())
			return Optional.empty();

//		System.out.println(inputFile.getContentType());
//		System.out.println(inputFile.getOriginalFilename());
//		System.out.println(inputFile.getSize());

		// Creating List of Employees to return
		List<Employee> employeesList = new ArrayList<>();
		// reading the csv file
		try (CSVReader reader = new CSVReader(new InputStreamReader(inputFile.getInputStream()))) {
			reader.readNext(); // skipping the header
			reader.forEach(data -> { // string array of data splitted by comma as it is .csv
				Employee employee = Employee.builder().userId(Integer.parseInt(data[0])).firstName(data[1])
						.lastName(data[2]).userEmail(data[3]).gender(data[4]).build();
				employeesList.add(employee);
			});

		} catch (IllegalStateException | IOException | CsvValidationException e) {
			e.printStackTrace();
			return Optional.of(List.of());
		}
		return Optional.of(employeesList);
	}

}
