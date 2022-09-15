package com.nasa.nafood.domain.service.restaurant;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.model.Cookery;
import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.repository.RestaurantRepository;
import com.nasa.nafood.domain.service.cookery.FindByIdCookeryService;

@Service
public class UpdateRestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private FindByIdCookeryService findByIdCookeryService;
	
	@Autowired
	private FindByIdRestaurantService findByIdRestaurantService;

	public Restaurant execute(Long restaurantId, Restaurant restaurant) {
		
		Restaurant restaurantUpdate = findByIdRestaurantService.execute(restaurantId);
		
		BeanUtils.copyProperties(restaurant, restaurantUpdate, "id", "payments", "address", "createdAt");
		
		Cookery cookery = restaurantUpdate.getCookery();
		
		if(cookery == null || cookery.getId() == null) {
			throw new EntityBadRequestException("The cookery is required and not null");
		};
		
		Long cookeryId = restaurantUpdate.getCookery().getId();
		
		Cookery cookeryExists = findByIdCookeryService.execute(cookeryId);
		
		restaurantUpdate.setCookery(cookeryExists);
	
		return restaurantRepository.save(restaurantUpdate);
	}
}
