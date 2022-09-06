package com.nasa.nafood.domain.service.restaurant;

import java.lang.reflect.Field;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.Cookery;
import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.repository.CookeryRepository;
import com.nasa.nafood.domain.repository.RestaurantRepository;

@Service
public class PatchRestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private CookeryRepository cookeryRepository;
	
	public Restaurant execute(Long restaurantId,  Map<String, Object> fields) {
		Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> 
			new EntityNotFoundException(String.format("The restaraunt with %d is not found.", restaurantId))
		);
	
		ObjectMapper objectMapper = new ObjectMapper();
		Restaurant restaurantFields = objectMapper.convertValue(fields, Restaurant.class);
		
		fields.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Restaurant.class, (String) key);
			field.setAccessible(true);
			Object newValue = ReflectionUtils.getField(field, restaurantFields);
			
			ReflectionUtils.setField(field, restaurant, newValue);
		});
			
		Cookery cookery = restaurant.getCookery();
		
		if(cookery == null || cookery.getId() == null) {
			throw new EntityBadRequestException("The cookery is required and not null");
		};
		
		Long cookeryId = restaurant.getCookery().getId();
		
		Cookery cookeryExists = cookeryRepository.findById(cookeryId).orElseThrow(() ->
			new EntityNotFoundException(String.format("The cookery with %d is not found", cookeryId))
		);
		
		restaurant.setCookery(cookeryExists);
	
		return restaurantRepository.save(restaurant);
	}
}
