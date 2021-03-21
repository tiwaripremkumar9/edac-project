package com.app.global_excs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.custom_excs.UserNotFoundException;
import com.app.dtos.ErrorResponse;
import java.util.NoSuchElementException;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	public GlobalExceptionHandler() {
		System.out.println(" in global exception handler  ");
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
		System.out.println("in handle user not found exc");
		return new ResponseEntity<>(new ErrorResponse("Invalid Login", ex.getMessage()),
				 HttpStatus.UNAUTHORIZED);
		
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErrorResponse> handleNoSuchElementException(NoSuchElementException ex) {
		System.out.println("in handle no such element exc");
		return new ResponseEntity<>(new ErrorResponse("Invalid food id", ex.getMessage()),
				 HttpStatus.UNAUTHORIZED);
		
	}
	
	
}
