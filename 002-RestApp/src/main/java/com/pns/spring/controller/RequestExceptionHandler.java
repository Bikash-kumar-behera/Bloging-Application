package com.pns.spring.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pns.spring.exception.ExtraArgumentsException;
import com.pns.spring.exception.InvalidDataArgumentsException;
import com.pns.spring.exception.MyCustomException;

@RestControllerAdvice
public class RequestExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(InvalidDataArgumentsException.class)
	public ResponseEntity<MyCustomException> handleInvalidDataArgument(InvalidDataArgumentsException exception,
			WebRequest request) {
		MyCustomException myCustomException = new MyCustomException(101, exception.getMessage());
		return new ResponseEntity<>(myCustomException, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ExtraArgumentsException.class)
	public ResponseEntity<MyCustomException> handleExtraArgument(ExtraArgumentsException exception,
			WebRequest request) {
		MyCustomException myCustomException = new MyCustomException(123, exception.getMessage());
		return new ResponseEntity<>(myCustomException, HttpStatus.FORBIDDEN);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		MyCustomException exception = new MyCustomException(400, "Malformed JSON request");
		return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		MyCustomException exception = new MyCustomException(415, "MediaType not supported");
		return new ResponseEntity<>(exception, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}
}
