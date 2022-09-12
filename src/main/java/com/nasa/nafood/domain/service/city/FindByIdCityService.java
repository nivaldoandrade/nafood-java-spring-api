package com.nasa.nafood.domain.service.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.City;
import com.nasa.nafood.domain.repository.CityRepository;

@Service
public class FindByIdCityService {

	private static final String MSG_CITY_NOT_FOUND = "The city with %d is not found";
	@Autowired
	private CityRepository cityRepository;
	
	public City execute(Long cityId) {
		return cityRepository.findById(cityId).orElseThrow(() -> 
		new EntityNotFoundException(String.format(MSG_CITY_NOT_FOUND, cityId)));	
	}

}
