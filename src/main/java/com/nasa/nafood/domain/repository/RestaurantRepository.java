package com.nasa.nafood.domain.repository;

import java.util.List;

import com.nasa.nafood.domain.model.Restaurant;

public interface RestaurantRepository {

	List<Restaurant> index();
	Restaurant show(Long id);
	Restaurant store(Restaurant restaurant);
	Restaurant update(Restaurant restaurant);
	void delete(Restaurant restaurant);
}
