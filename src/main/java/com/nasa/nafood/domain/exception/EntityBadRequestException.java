package com.nasa.nafood.domain.exception;

public class EntityBadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EntityBadRequestException(String message) {
		super(message);
	}

	public EntityBadRequestException(String message, Throwable cause) {
		super(message, cause);
	}
}
