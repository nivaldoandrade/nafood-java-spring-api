package com.nasa.nafood.api.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.exception.EntityNotFoundException;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handleEntityNotFoundExpection(EntityNotFoundException e) {
		ApiError error = ApiError.builder()
				.timestamp(LocalDateTime.now())
				.message(e.getMessage()).build();
		
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(error);
	}
	
	@ExceptionHandler(EntityBadRequestException.class)
	public ResponseEntity<?> handleEntityBadRequestException(EntityBadRequestException e) {
		ApiError error = ApiError.builder()
				.timestamp(LocalDateTime.now())
				.message(e.getMessage()).build();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(error);
	}
	
	
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class) 
	public ResponseEntity<?> handleHttpMediaTypeNotSupportedException() {
		ApiError error = ApiError.builder()
				.timestamp(LocalDateTime.now())
				.message("Unsupported Media Type").build();
		
		return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
				.body(error);
	}
}
