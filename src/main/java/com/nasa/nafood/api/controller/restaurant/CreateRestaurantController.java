package com.nasa.nafood.api.controller.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebInputException;

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
	public ResponseEntity<?> store(@RequestBody Restaurant restaurant) {
		try {
			restaurant =  createRestaurantService.execute(restaurant);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(restaurant);
			
		} catch (EntityBadRequestException e) {
			throw new ServerWebInputException(e.getMessage());
			
		} catch (EntityNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		} 
	
	}
}
