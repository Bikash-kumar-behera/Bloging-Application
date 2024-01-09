package com.pns.spring.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class RequestBean {
	@JsonProperty("empdetails")
	private List<EmployeeBean> employeeList;
}
