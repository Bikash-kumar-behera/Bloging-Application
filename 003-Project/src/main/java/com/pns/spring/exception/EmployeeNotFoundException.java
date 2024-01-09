package com.pns.spring.exception;

public class EmployeeNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 956566229292299L;

	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
