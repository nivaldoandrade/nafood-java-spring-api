package com.nasa.nafood.domain.service.restaurant;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.Cookery;
import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.repository.CookeryRepository;
import com.nasa.nafood.domain.repository.RestaurantRepository;

@Service
public class UpdateRestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private CookeryRepository cookeryRepository;
	
	@Autowired
	private FindByIdRestaurantService findByIdRestaurantService;
	
	public Restaurant execute(Long restaurantId, Restaurant restaurant) {
		Restaurant restaurantUpdate = findByIdRestaurantService.execute(restaurantId);
	
		BeanUtils.copyProperties(restaurant, restaurantUpdate, "id", "payments", "address", "createdAt");
		
		Cookery cookery = restaurantUpdate.getCookery();
		
		if(cookery == null || cookery.getId() == null) {
			throw new EntityBadRequestException("The cookery is required and not null");
		};
		
		Long cookeryId = restaurant.getCookery().getId();
		
		Cookery cookeryExists = cookeryRepository.findById(cookeryId).orElseThrow(() ->
			new EntityNotFoundException(String.format("The cookery with %d is not found", cookeryId))
		);
		
		restaurantUpdate.setCookery(cookeryExists);
	
		return restaurantRepository.save(restaurantUpdate);
	}
}
