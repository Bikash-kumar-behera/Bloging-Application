package com.pns.spring.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pns.spring.model.ResponseDTO;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		StringBuffer error = new StringBuffer("error(s): ");
		for(FieldError fieldError : ex.getBindingResult().getFieldErrors())
			error.append(fieldError.getDefaultMessage()).append(", ");
		error.setLength(error.length() - 2);
		return new ResponseEntity<>(new ResponseDTO<String>(400, error.toString(), null), ex.getStatusCode());
	}
	
	@ExceptionHandler(MyCustomException.class)
	public ResponseEntity<ResponseDTO<String>> handleMyCustomException(MyCustomException ex){
		return new ResponseEntity<>(new ResponseDTO<String>(-1, ex.getMessage(), null), HttpStatus.FORBIDDEN);
	}
}
