package com.nasa.nafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nasa.nafood.domain.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

//	List<Restaurant> index();
//	Restaurant show(Long id);
//	Restaurant store(Restaurant restaurant);
//	Restaurant update(Restaurant restaurant);
//	void delete(Restaurant restaurant);
}
