package com.pns.spring.exception;

import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pns.spring.model.ResponseDTO;

@RestControllerAdvice
public class ConsumerExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(SocketTimeoutException.class)
	public ResponseEntity<Object> handleSocketTimeoutException(SocketTimeoutException ex, WebRequest request) {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setDescription(ex.getMessage());
		return new ResponseEntity<>(responseDTO, HttpStatus.REQUEST_TIMEOUT);
	}
	@ExceptionHandler(SocketException.class)
	public ResponseEntity<Object> handleSocketException(SocketException ex, WebRequest request) {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setDescription(ex.getMessage());
		return new ResponseEntity<>(responseDTO, HttpStatus.REQUEST_TIMEOUT);
	}
	@ExceptionHandler(ConnectException.class)
	public ResponseEntity<Object> handleConnectionTimeoutException(ConnectException ex, WebRequest request) {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setDescription(ex.getMessage());
		return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
	}
}
