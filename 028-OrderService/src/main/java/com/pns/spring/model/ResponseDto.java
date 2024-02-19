package com.pns.spring.model;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ResponseDto<T> {
	private String message;
	private HttpStatus status;
	private T data;
}
