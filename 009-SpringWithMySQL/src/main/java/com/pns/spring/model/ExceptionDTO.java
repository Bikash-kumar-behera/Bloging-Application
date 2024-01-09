package com.pns.spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionDTO {
	@JsonProperty(value = "description")
	private String message;
	@JsonProperty(value = "status_code")
	private int status;
}
