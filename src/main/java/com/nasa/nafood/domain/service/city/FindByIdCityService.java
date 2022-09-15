package com.nasa.nafood.domain.service.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.CityNotFoundException;
import com.nasa.nafood.domain.model.City;
import com.nasa.nafood.domain.repository.CityRepository;

@Service
public class FindByIdCityService {

	@Autowired
	private CityRepository cityRepository;
	
	public City execute(Long cityId) {
		return cityRepository.findById(cityId).orElseThrow(() -> 
		new CityNotFoundException(cityId));	
	}

}
