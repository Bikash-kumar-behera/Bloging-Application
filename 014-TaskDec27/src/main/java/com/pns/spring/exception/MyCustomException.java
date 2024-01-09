package com.pns.spring.exception;

public class MyCustomException extends RuntimeException {
	
	private static final long serialVersionUID = -3239830308251732094L;

	public MyCustomException(String message) {
		super(message);
	}
}
