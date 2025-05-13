package com.khurram.blogapp.exceptions;

import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 

@ControllerAdvice 
public class GlobalExceptionHandler {
	
	@ExceptionHandler(PostNotFoundException.class)
	public ResponseEntity<Object> handlePostNotFound(PostNotFoundException ex){
		Map<String, Object> errorDetails = new HashMap<>();
		
		errorDetails.put("TimeStamp ", LocalDateTime.now());
		errorDetails.put("Message ", ex.getMessage());
		errorDetails.put("Status ", HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
		
	}
}
