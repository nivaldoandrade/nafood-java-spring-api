package com.nasa.nafood.domain.service.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityInUseException;
import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.repository.RestaurantRepository;

@Service
public class DeleteRestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private FindByIdRestaurantService findByIdRestaurantService;
	
	public void execute(long restaurantId) {
		Restaurant restaurant = findByIdRestaurantService.execute(restaurantId);
		
		try {
			restaurantRepository.delete(restaurant);
		} catch (DataIntegrityViolationException e) {
			throw new EntityInUseException(String.format("the restaurant with id %d is being used", restaurantId));
		}

	} 
}
