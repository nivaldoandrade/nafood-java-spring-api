package com.nasa.nafood.domain.service.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.repository.RestaurantRepository;

@Service
public class FindByIdRestaurantService {

	private static final String MSG_RESTAURANT_NOT_FOUND = "The restaurant with %d id is not found";
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	public Restaurant execute(Long restaurantId) {
		return restaurantRepository.findById(restaurantId)
				.orElseThrow(() -> new EntityNotFoundException(String.format(MSG_RESTAURANT_NOT_FOUND, restaurantId)));
	}
}
