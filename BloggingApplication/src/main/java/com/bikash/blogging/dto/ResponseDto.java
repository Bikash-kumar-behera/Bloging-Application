package com.bikash.blogging.dto;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class ResponseDto<T> {
	private String message;
	@JsonIgnore
	private HttpStatus status;
	private T data;
}
