package com.nasa.nafood.api.controller.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.domain.service.restaurant.DeleteRestaurantService;

@RestController
@RequestMapping("/restaurants/{restaurantId}")
public class DeleteRestaurantController {
	@Autowired
	private DeleteRestaurantService deleteRestaurantService;
	
	@DeleteMapping
	public void delete(@PathVariable long restaurantId) {
		deleteRestaurantService.execute(restaurantId);
	}
}
