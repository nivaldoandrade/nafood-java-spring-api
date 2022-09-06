package com.nasa.nafood.api.controller.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.domain.model.City;
import com.nasa.nafood.domain.service.city.CreateCityService;

@RestController
@RequestMapping("/cities")
public class CreateCityController {
	
	@Autowired
	private CreateCityService createCityService;
	
	@PostMapping
	public City create(@RequestBody City city) {
		return createCityService.execute(city);	
	}
}
