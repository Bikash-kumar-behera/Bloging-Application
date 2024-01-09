package com.pns.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pns.spring.exception.CustomException;
import com.pns.spring.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class ExceptionsHandler {
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<CustomException> handleEmployeeNotFound() {
		CustomException exception = new CustomException();
		exception.setErrorCode(101);
		exception.setErrorMessage("Employee Not Found");
		return new ResponseEntity<>(exception,HttpStatus.NOT_FOUND);
	}
}
