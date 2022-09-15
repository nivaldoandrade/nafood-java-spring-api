package com.nasa.nafood.api.controller.restaurant;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.domain.exception.CookeryNotFoundException;
import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.service.restaurant.PatchRestaurantService;

@RestController
@RequestMapping("/restaurants/{restaurantId}")
public class PacthRestaurantController {
	
	@Autowired
	private PatchRestaurantService patchRestaurantService;
	
	@PatchMapping
	public Restaurant update(@PathVariable Long restaurantId, @RequestBody Map<String, Object> fields) {
		try {
			return patchRestaurantService.execute(restaurantId, fields);
			
		} catch (CookeryNotFoundException e) {
			throw new EntityBadRequestException(e.getMessage(), e);
			
		}
	}
}
