package com.nasa.nafood.domain.service.restaurant;

import java.util.Optional;

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
		Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
		
		if(restaurantOptional.isEmpty()) {
			throw new EntityNotFoundException(String.format("The restaurant with %d is not found", id));
		};
		
		Restaurant restaurant = restaurantOptional.get();
		
		restaurantRepository.delete(restaurant);
	} 
}
