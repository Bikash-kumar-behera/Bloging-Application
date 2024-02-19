package com.pns.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pns.spring.model.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{
}
