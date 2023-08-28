package com.example.exceptions;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHanlder  extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(ResourseNotFoundException e)
	{
		ErrorResponse err=new ErrorResponse();
		err.setStatuscode(400);
		err.setStatusMessage(e.getMessage());
		
		return new ResponseEntity<ErrorResponse>(err,HttpStatus.NOT_FOUND);
		
	}

}
