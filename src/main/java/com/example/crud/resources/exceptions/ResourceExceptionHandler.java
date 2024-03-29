package com.example.crud.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.crud.services.exceptions.DatabaseException;
import com.example.crud.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler (ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		
		String error = "Resource Not Fond.";
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		
		StandardError se = new StandardError(Instant.now(),status.value(), error, e.getMessage(),request.getRequestURI()); 	
		
		return ResponseEntity.status(status).body(se);
		
		
	}
	
	
	@ExceptionHandler (DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
		
		String error = "Database error.";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		
		StandardError se = new StandardError(Instant.now(),status.value(), error, e.getMessage(),request.getRequestURI()); 	
		
		return ResponseEntity.status(status).body(se);
		
		
	}

}
