package com.nasa.nafood.domain.service.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.repository.RestaurantRepository;

@Service
public class DeleteRestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	public void execute(long id) {
		Restaurant restaurant = restaurantRepository.show(id);
		
		if(restaurant == null) {
			throw new EntityNotFoundException(String.format("The restaurant with %d is not found", id));
		};
		
		restaurantRepository.delete(restaurant);
	} 
}
