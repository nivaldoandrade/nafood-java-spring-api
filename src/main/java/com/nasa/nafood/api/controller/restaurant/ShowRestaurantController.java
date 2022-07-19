package com.nasa.nafood.api.controller.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.service.restaurant.ShowRestaurantService;

@RestController
@RequestMapping("/restaurants/{restaurantId}")
public class ShowRestaurantController {
	@Autowired
	private ShowRestaurantService showRestaurantService;
	
	@GetMapping
	public ResponseEntity<Restaurant> show(@PathVariable long restaurantId) {
		Restaurant restaurant = showRestaurantService.execute(restaurantId);
		
		if(restaurant == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(restaurant);
	} 
}
