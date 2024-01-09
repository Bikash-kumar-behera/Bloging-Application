package com.pns.spring.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pns.spring.model.MyCustomExceptionDto;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		StringBuffer errorMessage = new StringBuffer("errors(): ");
		for(FieldError error: ex.getFieldErrors())
			errorMessage.append(error.getDefaultMessage()).append(", ");
		errorMessage.setLength(errorMessage.length()-2);
		MyCustomExceptionDto customExceptionDto = new MyCustomExceptionDto();
		customExceptionDto.setMessage(errorMessage.toString());
		customExceptionDto.setStatus(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(customExceptionDto, customExceptionDto.getStatus());
	}
}
