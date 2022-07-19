package com.nasa.nafood.api.controller.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.service.restaurant.ListRestaurantsService;

@RestController
@RequestMapping("/restaurants")
public class ListRestaurantController {
	@Autowired
	private ListRestaurantsService listRestaurantsService;
	
	@GetMapping
	public List<Restaurant> index() {
		return listRestaurantsService.execute();
	}
}
