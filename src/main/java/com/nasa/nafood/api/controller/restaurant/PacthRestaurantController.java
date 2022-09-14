package com.nasa.nafood.api.controller.restaurant;

import java.lang.reflect.Field;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.service.restaurant.FindByIdRestaurantService;
import com.nasa.nafood.domain.service.restaurant.PatchRestaurantService;

@RestController
@RequestMapping("/restaurants/{restaurantId}")
public class PacthRestaurantController {
	
	@Autowired
	private PatchRestaurantService patchRestaurantService;
	
	@Autowired
	private FindByIdRestaurantService findByIdRestaurantService;
	
	@PatchMapping
	public Restaurant update(@PathVariable Long restaurantId, @RequestBody Map<String, Object> fields) {
		Restaurant restaurant = findByIdRestaurantService.execute(restaurantId);
	
		ObjectMapper objectMapper = new ObjectMapper();
		Restaurant restaurantFields = objectMapper.convertValue(fields, Restaurant.class);
		
		fields.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Restaurant.class, (String) key);
			field.setAccessible(true);
			Object newValue = ReflectionUtils.getField(field, restaurantFields);
			
			ReflectionUtils.setField(field, restaurant, newValue);
		});
			
		try {
			return patchRestaurantService.execute(restaurantId, restaurant);
		} catch (EntityNotFoundException e) {
			throw new EntityBadRequestException(e.getMessage());
		}
		
	}
}
