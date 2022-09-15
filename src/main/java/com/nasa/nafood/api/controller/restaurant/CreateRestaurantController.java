package com.nasa.nafood.api.controller.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.service.restaurant.CreateRestaurantService;

@RestController
@RequestMapping("/restaurants")
public class CreateRestaurantController {
	@Autowired
	private CreateRestaurantService createRestaurantService;
	
//	@PostMapping
//	public ResponseEntity<?> store(@RequestBody Restaurant restaurant) {
//		restaurant =  createRestaurantService.execute(restaurant);
//		
//		return ResponseEntity.status(HttpStatus.CREATED).body(restaurant);
//	
//	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Restaurant store(@RequestBody Restaurant restaurant) {
		try {
			return createRestaurantService.execute(restaurant);
		} catch (EntityNotFoundException e) {
			throw new EntityBadRequestException(e.getMessage(), e);
		}	
	}
}
