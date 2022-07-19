package com.nasa.nafood.domain.service.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.City;
import com.nasa.nafood.domain.repository.CityRepository;

@Service
public class ShowCityService {
	
	@Autowired
	private CityRepository cityRepository;
	
	public City execute(Long id) {
		City city = cityRepository.show(id);
		
		
		if(city == null) {
			throw new EntityNotFoundException(String.format("The city with %d is not found", id));
		};
		
		return city;
	}
}
