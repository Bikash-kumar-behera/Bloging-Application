package com.pns.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pns.spring.entity.Employee;
public interface EmployeeDao extends JpaRepository<Employee, Integer>{}
