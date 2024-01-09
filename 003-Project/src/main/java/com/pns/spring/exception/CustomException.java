package com.pns.spring.exception;

import lombok.Data;

@Data
public class CustomException {
	private int errorCode;
	private String errorMessage;
}
