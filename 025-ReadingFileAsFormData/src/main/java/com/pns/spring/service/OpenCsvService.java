package com.pns.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pns.spring.model.Employee;

@Service
public interface OpenCsvService {
	Optional<List<Employee>> readAllEmployeesFromCsv(MultipartFile employeesFile);
}
