package com.pns.spring.service.impl;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.pns.spring.model.Employee;
import com.pns.spring.model.EmployeeResponseDto;
import com.pns.spring.repository.EmployeeRepository;
import com.pns.spring.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public EmployeeResponseDto addEmployeesToDatabase(List<Employee> employees) {
		EmployeeResponseDto response;

		try {
			long startTime = System.currentTimeMillis();

//			employees = employeeRepository.saveAll(employees); // 3353ms
//			employees.forEach(employee -> employeeRepository.save(employee));//7527ms
//			employees.parallelStream().forEach(employee -> employeeRepository.save(employee));//1872ms
//			employees.stream().forEach(employee -> employeeRepository.save(employee));//7036ms

			// 1347ms
//			List<List<Employee>> subLists = ListUtils.partition(employees, 10);
//			subLists.parallelStream().forEach(subList -> subList.parallelStream().forEach(employee -> employeeRepository.save(employee)));

			// 1279ms
//			List<List<Employee>> subLists = ListUtils.partition(employees, 100);
//			ExecutorService worker = Executors.newFixedThreadPool(100);
//			subLists.forEach(
//					subList -> worker.submit(() -> subList.forEach(employee -> employeeRepository.save(employee))));
//			worker.shutdown();
//			worker.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

			// 923ms for 10 threads with 10 connection pool size
			// 471ms for 100 threads and 100 connection pool size
			
			List<List<Employee>> subLists = ListUtils.partition(employees, 100);
			ExecutorService worker = Executors.newFixedThreadPool(100);

			subLists.forEach(subList -> worker.submit(() -> employeeRepository.saveAll(subList)));
			worker.shutdown();
			worker.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

			long endTime = System.currentTimeMillis();
			response = EmployeeResponseDto.builder().status(HttpStatus.OK)
					.message("Successfully saved to DB in " + (endTime - startTime) + "ms").build();
		} catch (Exception e) {
			e.printStackTrace();
			response = EmployeeResponseDto.builder().status(HttpStatus.INTERNAL_SERVER_ERROR)
					.message("Something went wrong").build();
		}
		return response;
	}

}
