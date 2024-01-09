package com.pns.spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class DepartmentBean {
	@JsonProperty(value = "deptname")
	private String deptName;
}
