package com.nasa.nafood.domain.service.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.model.Cookery;
import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.repository.RestaurantRepository;
import com.nasa.nafood.domain.service.cookery.FindByIdCookeryService;

@Service
public class CreateRestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private FindByIdCookeryService findByIdCookeryService;
	
	
	public Restaurant execute(Restaurant restaurant) {
		
		if(restaurant.getCookery() == null || restaurant.getCookery().getId() == null) {
			throw new EntityBadRequestException("The cookery cannot be null");
		}
		
		Long cookeryId = restaurant.getCookery().getId();
	
		Cookery cookery = findByIdCookeryService.execute(cookeryId);
		
		restaurant.setCookery(cookery);
		
		return restaurantRepository.save(restaurant);
	}
}
