package com.nasa.nafood.domain.service.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.model.Cookery;
import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.repository.RestaurantRepository;
import com.nasa.nafood.domain.service.cookery.FindByIdCookeryService;

@Service
public class PatchRestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private FindByIdCookeryService findByIdCookeryService;
	
	public Restaurant execute(Long restaurantId,  Restaurant restaurant) {

		Cookery cookery = restaurant.getCookery();
		
		if(cookery == null || cookery.getId() == null) {
			throw new EntityBadRequestException("The cookery is required and not null");
		};
		
		Long cookeryId = restaurant.getCookery().getId();
		
		Cookery cookeryExists = findByIdCookeryService.execute(cookeryId);
		
		restaurant.setCookery(cookeryExists);
	
		return restaurantRepository.save(restaurant);
	}
}
