package com.nasa.nafood.api.controller.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.City;
import com.nasa.nafood.domain.service.city.DeleteCityService;

@RestController
@RequestMapping("/cities/{cityId}")
public class DeleteCityController {
	
	@Autowired
	private DeleteCityService deleteCityService;
	
	@DeleteMapping
	public ResponseEntity<City> delete(@PathVariable long cityId) {
		try {
			deleteCityService.execute(cityId);
			
			return ResponseEntity.noContent().build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
