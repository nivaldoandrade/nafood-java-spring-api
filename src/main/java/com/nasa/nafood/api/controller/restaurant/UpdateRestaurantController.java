package com.nasa.nafood.api.controller.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.service.restaurant.UpdateRestaurantService;

@RestController
@RequestMapping("/restaurants/{restaurantId}")
public class UpdateRestaurantController {
	
	@Autowired
	private UpdateRestaurantService updateRestaurantService;
	
	@PutMapping
	public ResponseEntity<?> update(@PathVariable long restaurantId, @RequestBody Restaurant restaurant) {
		try {
			restaurant = updateRestaurantService.execute(restaurantId, restaurant);
			System.out.println(restaurant.getName());
			
			return ResponseEntity.ok(restaurant);
		} catch (Exception e) {
			
			if(e instanceof EntityNotFoundException) {
				return ResponseEntity.notFound().build();
			}
			
			if(e instanceof EntityBadRequestException) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
			
			System.out.println(e.getMessage());
			return ResponseEntity.internalServerError().build();
		}
	}
}
