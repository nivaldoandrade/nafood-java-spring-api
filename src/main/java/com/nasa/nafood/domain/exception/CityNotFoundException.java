package com.nasa.nafood.domain.exception;


public class CityNotFoundException extends EntityNotFoundException{

	private static final long serialVersionUID = 1L;

	public CityNotFoundException(String message) {
		super(message);
	}
	
	public CityNotFoundException(long cityId) {
		this(String.format("The city with id test %d is not found", cityId));
	}
}
