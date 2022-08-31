package com.nasa.nafood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntityBadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EntityBadRequestException(String message) {
		super(message);
	}

}
