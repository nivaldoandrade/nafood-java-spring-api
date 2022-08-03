package com.nasa.nafood.domain.service.restaurant;

import java.util.Optional;

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
	
	public Restaurant execute(Long id, Restaurant restaurant) {
		Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
		
		if(restaurantOptional.isEmpty()) {
			throw new EntityNotFoundException(String.format("The restaurant with %d is not found", id));
		};
		
		Restaurant restaurantUpdate = restaurantOptional.get();
		
		BeanUtils.copyProperties(restaurant, restaurantUpdate, "id");
		
		Cookery cookery = restaurantUpdate.getCookery();
		
		if(cookery == null || cookery.getId() == null) {
			throw new EntityBadRequestException("The cookery is required and not null");
		};
		
		Long cookeryId = restaurant.getCookery().getId();
		Optional<Cookery> cookeryOptional = cookeryRepository.findById(cookeryId);
		
		
		if(cookeryOptional.isEmpty()) {
			throw new EntityBadRequestException(String.format("The cookery with %d is not found", cookeryId));
		};
		
		restaurantUpdate.setCookery(cookeryOptional.get());
	
		
		return restaurantRepository.save(restaurantUpdate);
	}
}
