package com.te.learnspringbootwithdatajpa.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.learnspringbootwithdatajpa.exceptions.EmployeeNotFoundException;
import com.te.learnspringbootwithdatajpa.response.GeneralResponse;

@ControllerAdvice
public class ApplicationExceptionControllerAdvice {

	@ExceptionHandler(value = { EmployeeNotFoundException.class })
	public ResponseEntity<GeneralResponse> handler(EmployeeNotFoundException e) {
		return ResponseEntity.badRequest()
				.body(new GeneralResponse(null, HttpStatus.BAD_REQUEST, e.getMessage(), null, null));
	}

	@ExceptionHandler(value = { NullPointerException.class })
	public ResponseEntity<GeneralResponse> handler(NullPointerException e) {
		return ResponseEntity.badRequest()
				.body(new GeneralResponse(null, HttpStatus.BAD_REQUEST, "Something went wrong!", null, null));
	}
}
