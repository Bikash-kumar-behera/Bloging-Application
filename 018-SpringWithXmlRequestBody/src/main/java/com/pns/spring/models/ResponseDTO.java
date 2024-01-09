package com.pns.spring.models;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "response")
public class ResponseDTO<T> {
	
	@JacksonXmlElementWrapper(localName = "message")
	private String message;

	@JacksonXmlElementWrapper(localName = "status")
	private HttpStatus status;

	@JacksonXmlElementWrapper(localName = "data")
	private T data;
}
