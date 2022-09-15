package com.nasa.nafood.domain.exception;

public class CookeryNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public CookeryNotFoundException(String message) {
		super(message);
	}
	
	public CookeryNotFoundException(long cookeryId) {
		this(String.format("The cookery with id %d is not found", cookeryId));
	}

}
