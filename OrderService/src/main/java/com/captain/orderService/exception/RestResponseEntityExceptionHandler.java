package com.captain.orderService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.captain.orderService.external.response.ErrorResponse;



@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> handleCustomException(CustomException exception){
		new ErrorResponse();
		return new ResponseEntity<>(ErrorResponse.builder()
				.errorMessage(exception.getMessage())
				.errorCode(exception.getErrorCode())
				.build(), HttpStatus.valueOf(exception.getStatus()));
	}
}
