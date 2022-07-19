package com.nasa.nafood.api.controller.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.service.restaurant.DeleteRestaurantService;

@RestController
@RequestMapping("/restaurants/{restaurantId}")
public class DeleteRestaurantController {
	@Autowired
	private DeleteRestaurantService deleteRestaurantService;
	
	@DeleteMapping
	public ResponseEntity<Restaurant> delete(@PathVariable long restaurantId) {
		try {
			deleteRestaurantService.execute(restaurantId);
			
			return ResponseEntity.noContent().build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
