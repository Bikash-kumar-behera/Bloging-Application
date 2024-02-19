package com.pns.spring.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pns.spring.model.ResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(MyCustomException.class)
	protected ResponseEntity<ResponseDto<String>> handleMyCustomException(MyCustomException ex) {
		return new ResponseEntity<>(new ResponseDto<>(ex.getStatus(),ex.getMessage(),null),ex.getStatus());
	}
}
