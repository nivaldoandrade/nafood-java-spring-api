package com.nasa.nafood.domain.service.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.model.Restaurant;

@Service
public class ShowRestaurantService {

	@Autowired
	private FindByIdRestaurantService findByIdRestaurantService;
	
	public Restaurant execute(Long restaurantId) {
		return findByIdRestaurantService.execute(restaurantId);
	}
}
