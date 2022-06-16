package com.alzohar.relationship.webservice.ExceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alzohar.relationship.webservice.Exception.OrderNotFound;
import com.alzohar.relationship.webservice.Exception.ProductNotFound;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = ProductNotFound.class)
	public ResponseEntity<ExceptionResponse> productNotFound(ProductNotFound exception) {
		ExceptionResponse response = new ExceptionResponse(exception.getMessage(), new Date(),
				HttpStatus.NOT_FOUND.name(), exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = OrderNotFound.class)
	public ResponseEntity<ExceptionResponse> orderNotFound(OrderNotFound exception) {
		ExceptionResponse response = new ExceptionResponse(exception.getMessage(), new Date(),
				HttpStatus.NOT_FOUND.name(), exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
}
