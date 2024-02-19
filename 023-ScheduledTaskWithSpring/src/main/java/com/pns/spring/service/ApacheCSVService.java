package com.pns.spring.service;

import java.util.List;

import com.pns.spring.entity.Employee;

public interface ApacheCSVService {
	String writeEmployeesToCsv(String[] header,List<Employee> list);
}
