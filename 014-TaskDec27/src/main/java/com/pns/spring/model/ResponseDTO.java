package com.pns.spring.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO<T> {
	
	@JsonProperty("error_code")
	private Integer errorCode;
	
	@JsonProperty("description")
	private String message;
	
	@JsonProperty("data")
	private T t;
}
