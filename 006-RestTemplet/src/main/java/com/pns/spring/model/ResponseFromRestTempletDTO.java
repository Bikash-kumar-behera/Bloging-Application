package com.pns.spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ResponseFromRestTempletDTO {
	private String message;
	@JsonProperty("data")
	private EmployeeDTO employee;
}
