package com.pns.spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class EmployeeBean {
	@JsonProperty(value = "code")
	private int code;
	
	@JsonProperty(value = "name")
	private String name;
	
	@JsonProperty("department")
	private DepartmentBean department;
}
