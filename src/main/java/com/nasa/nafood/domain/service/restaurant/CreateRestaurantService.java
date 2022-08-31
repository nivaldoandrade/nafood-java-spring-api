package com.nasa.nafood.domain.service.restaurant;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.Cookery;
import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.repository.CookeryRepository;
import com.nasa.nafood.domain.repository.RestaurantRepository;

@Service
public class CreateRestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private CookeryRepository cookeryRepository;
	
	
	public Restaurant execute(Restaurant restaurant) {
		
		if(restaurant.getCookery() == null || restaurant.getCookery().getId() == null) {
			throw new EntityBadRequestException("The cookery cannot be null");
		}
		
		Long cookeryId = restaurant.getCookery().getId();
	
		Optional<Cookery> cookery = cookeryRepository.findById(cookeryId);
		
		if(cookery.isEmpty()) {
			throw new EntityNotFoundException(String.format("The cookery with %d is not found.", cookeryId));
		};
		
		restaurant.setCookery(cookery.get());
		
		return restaurantRepository.save(restaurant);
	}
}
