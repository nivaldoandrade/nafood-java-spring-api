package com.nasa.nafood.domain.service.restaurant;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.repository.RestaurantRepository;

@Service
public class ShowRestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	public Restaurant execute(Long id) {
		Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
		
		if(restaurantOptional.isEmpty()) {
			throw new EntityNotFoundException(String.format("The restaurant with %d id is not found", id));
		}
		
		return restaurantOptional.get();
	}
}
