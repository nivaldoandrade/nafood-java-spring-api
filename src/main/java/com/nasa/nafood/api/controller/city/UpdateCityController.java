package com.nasa.nafood.api.controller.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.exception.StateNotFoundException;
import com.nasa.nafood.domain.model.City;
import com.nasa.nafood.domain.service.city.UpdateCityService;

@RestController
@RequestMapping("/cities/{cityId}")
public class UpdateCityController {
	
	@Autowired
	private UpdateCityService updateCityService;
	
	@PutMapping
	public City store(@PathVariable long cityId, @RequestBody City city) {
		try {
			return updateCityService.execute(cityId, city);
			
		} catch (StateNotFoundException e) {
			throw new EntityBadRequestException(e.getMessage(), e);
		}
			
	}

}
