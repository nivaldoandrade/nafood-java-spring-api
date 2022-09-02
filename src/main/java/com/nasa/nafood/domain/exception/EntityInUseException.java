package com.nasa.nafood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

//@ResponseStatus(HttpStatus.CONFLICT)
public class EntityInUseException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;
	
	
	public EntityInUseException(HttpStatus status, String reason) {
		super(status, reason);
	}

	public EntityInUseException(String message) {
		this(HttpStatus.CONFLICT, message);
	}

}
