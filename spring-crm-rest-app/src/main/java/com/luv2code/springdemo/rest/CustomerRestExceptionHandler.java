package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	// add an exception for handling customer not found exception
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc) {

		// create CustomerErrorResponse
		CustomerErrorResponse err = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(),
				System.currentTimeMillis());

		// return Response Entity with it
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);

	}

	// add an exception handler to handle any other kind of exception
	public ResponseEntity<CustomerErrorResponse> handleExcepion(CustomerNotFoundException exc){
		
		//create Customer Error Response
		CustomerErrorResponse err = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage() , System.currentTimeMillis());
		
		//return errorResp
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		
		
	}

}
