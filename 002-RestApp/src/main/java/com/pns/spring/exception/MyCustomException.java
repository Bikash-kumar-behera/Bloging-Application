package com.pns.spring.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MyCustomException {
	private int errorCode;
	private String errorMessage;
}
