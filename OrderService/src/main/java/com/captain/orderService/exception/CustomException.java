package com.captain.orderService.exception;

import lombok.Data;

@Data
public class CustomException extends RuntimeException{

	private int status;
	private String errorCode;
	
	public CustomException(String message, int status, String errorCode) {
		super(message);
		this.status = status;
		this.errorCode = errorCode;
	}
}
