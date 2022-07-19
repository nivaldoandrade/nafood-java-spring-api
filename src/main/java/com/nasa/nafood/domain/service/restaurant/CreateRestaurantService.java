package com.nasa.nafood.domain.service.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityBadRequestException;
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
		Long cookeryId = restaurant.getCookery().getId();
		Cookery cookery = cookeryRepository.show(cookeryId);
		
		if(cookery == null) {
			throw new EntityBadRequestException(String.format("The cookery with %d is not found.", cookeryId));
		};
		
		restaurant.setCookery(cookery);
		
		return restaurantRepository.store(restaurant);
	}
}
