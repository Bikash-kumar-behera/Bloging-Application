package com.pns.spring.exception;

public class InvalidDataArgumentsException extends RuntimeException {
	public InvalidDataArgumentsException(String message) {
		super(message);
	}
}