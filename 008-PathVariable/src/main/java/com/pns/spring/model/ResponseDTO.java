package com.pns.spring.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseDTO {
	private int id;
	private EmployeeDTO employee;
	private String message;
}
