package com.nasa.nafood.domain.service.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.model.City;

@Service
public class ShowCityService {
	
	@Autowired
	private FindByIdCityService findByIdCityService;
	
	public City execute(Long cityId) {
		return findByIdCityService.execute(cityId);
	}
}
