package com.pns.spring.model;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class MyCustomExceptionDto {
	private String message;
	@JsonIgnore
	private HttpStatus status;
}
