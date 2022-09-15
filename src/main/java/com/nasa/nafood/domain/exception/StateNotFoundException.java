package com.nasa.nafood.domain.exception;

public class StateNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public StateNotFoundException(String message) {
		super(message);
	}
	
	public StateNotFoundException(long stateId) {
		this(String.format("The state with id %d is not found", stateId));
	} 

}
