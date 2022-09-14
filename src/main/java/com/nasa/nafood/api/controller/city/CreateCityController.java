package com.nasa.nafood.api.controller.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.City;
import com.nasa.nafood.domain.service.city.CreateCityService;

@RestController
@RequestMapping("/cities")
public class CreateCityController {
	
	@Autowired
	private CreateCityService createCityService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public City create(@RequestBody City city) {
		try {
			return createCityService.execute(city);	
		} catch (EntityNotFoundException e) {
			throw new EntityBadRequestException(e.getMessage());
		}
	}
}
