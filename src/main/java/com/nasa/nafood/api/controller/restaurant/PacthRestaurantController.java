package com.nasa.nafood.api.controller.restaurant;

import java.lang.reflect.Field;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.repository.RestaurantRepository;

@RestController
@RequestMapping("/restaurants/{restaurantId}")
public class PacthRestaurantController {

	@Autowired
	private UpdateRestaurantController updateRestaurantController;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@PatchMapping
	public ResponseEntity<?> update(@PathVariable Long restaurantId, @RequestBody Map<String, Object> fields) {
		Restaurant restaurant = restaurantRepository.show(restaurantId);
		
		if(restaurant == null) {
			return ResponseEntity.notFound().build();
		}

		ObjectMapper objectMapper = new ObjectMapper();
		Restaurant restaurantFields = objectMapper.convertValue(fields, Restaurant.class);
		
		fields.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Restaurant.class, (String) key);
			field.setAccessible(true);
			Object newValue = ReflectionUtils.getField(field, restaurantFields);
			
			ReflectionUtils.setField(field, restaurant, newValue);
		});
	

		return updateRestaurantController.update(restaurantId, restaurant);
	}
}
