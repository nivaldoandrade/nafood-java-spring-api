package com.nasa.nafood.domain.service.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.repository.RestaurantRepository;

@Service
public class ListRestaurantsService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	public List<Restaurant> execute() {
		return restaurantRepository.findAll();
	}
}
