package com.pns.spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EligibleEmployeeBean {
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("empstatus")
	private String empStatus;
}
