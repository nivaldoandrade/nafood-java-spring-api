package com.nasa.nafood.api.controller.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.City;
import com.nasa.nafood.domain.service.city.UpdateCityService;

@RestController
@RequestMapping("/cities/{cityId}")
public class UpdateCityController {
	
	@Autowired
	private UpdateCityService updateCityService;
	
	@PutMapping
	public ResponseEntity<?> store(@PathVariable long cityId, @RequestBody City city) {
		try {
			City cityUpdate = updateCityService.execute(cityId, city);
			
			return ResponseEntity.ok(cityUpdate);
					
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
			
		} catch (EntityBadRequestException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
