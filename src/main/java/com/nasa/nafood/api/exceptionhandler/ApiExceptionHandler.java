package com.nasa.nafood.api.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.exception.EntityInUseException;
import com.nasa.nafood.domain.exception.EntityNotFoundException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handleEntityNotFoundExpection(EntityNotFoundException ex) {
		
		return handleExceptionInternal(ex, ex.getMessage(), null, HttpStatus.NOT_FOUND, null);
		
	
//		ApiError error = ApiError.builder()
//				.timestamp(LocalDateTime.now())
//				.message(e.getMessage()).build();
//		
//		
//		return ResponseEntity.status(HttpStatus.NOT_FOUND)
//				.body(error);
	}
	
	@ExceptionHandler(EntityBadRequestException.class)
	public ResponseEntity<?> handleEntityBadRequestException(EntityBadRequestException e) {
		ApiError error = ApiError.builder()
				.timestamp(LocalDateTime.now())
				.message(e.getMessage()).build();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(error);
	}
	
	@ExceptionHandler(EntityInUseException.class)
	public ResponseEntity<?> handleEntityInUseException(EntityInUseException e) {
		ApiError error = ApiError.builder()
				.timestamp(LocalDateTime.now())
				.message(e.getMessage())
				.build();
		
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(error);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		

		if(body == null) {
			body = ApiError.builder()
					.timestamp(LocalDateTime.now())
					.message(status.getReasonPhrase())
					.build();
		} else {
			body = ApiError.builder()
					.timestamp(LocalDateTime.now())
					.message((String) body)
					.build();
		}
		
		
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}
}
