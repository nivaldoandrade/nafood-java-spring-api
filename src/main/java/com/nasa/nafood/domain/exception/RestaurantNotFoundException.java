package com.nasa.nafood.domain.exception;

public class RestaurantNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;

	public RestaurantNotFoundException(String message) {
		super(message);
	}
	
	public RestaurantNotFoundException(long restaurantId) {
		this(String.format("The restaurant with id %d is not found", restaurantId));
	}
}
