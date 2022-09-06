package com.nasa.nafood.api.controller.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.domain.model.City;
import com.nasa.nafood.domain.service.city.ShowCityService;

@RestController
@RequestMapping("/cities/{cityId}")
public class ShowCityController {

	@Autowired
	private ShowCityService showCityService;
	
	@GetMapping
	public City show(@PathVariable Long cityId) {
		return showCityService.execute(cityId);

	}
}
