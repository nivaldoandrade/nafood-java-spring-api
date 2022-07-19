package com.nasa.nafood.api.controller.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.domain.model.City;
import com.nasa.nafood.domain.service.city.ListCityService;

@RestController
@RequestMapping("/cities")
public class ListCityController {
	
	@Autowired
	private ListCityService listCityService;

	@GetMapping
	public List<City> index() {
		return listCityService.execute();
	}
}
