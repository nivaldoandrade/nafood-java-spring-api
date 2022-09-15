package com.nasa.nafood.api.controller.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.domain.exception.CookeryNotFoundException;
import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.service.restaurant.UpdateRestaurantService;

@RestController
@RequestMapping("/restaurants/{restaurantId}")
public class UpdateRestaurantController {
	
	@Autowired
	private UpdateRestaurantService updateRestaurantService;
	
	@PutMapping
	public Restaurant update(@PathVariable long restaurantId, @RequestBody Restaurant restaurant) {
		try {
			return updateRestaurantService.execute(restaurantId, restaurant);
			
		} catch (CookeryNotFoundException e) {
			throw new EntityBadRequestException(e.getMessage(), e);
			
		}
	}
}
