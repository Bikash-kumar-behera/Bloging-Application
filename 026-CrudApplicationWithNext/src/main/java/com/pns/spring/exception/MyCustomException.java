package com.pns.spring.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

public class MyCustomException extends RuntimeException {

	private static final long serialVersionUID = 2366730519896623380L;
	@Getter
	private String msg;
	@Getter
	private HttpStatus status;
	
	public MyCustomException(String msg, HttpStatus status) {
		super(msg);
		this.msg = msg;
		this.status = status;
	}

}
