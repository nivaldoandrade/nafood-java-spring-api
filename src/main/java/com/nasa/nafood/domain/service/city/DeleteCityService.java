package com.nasa.nafood.domain.service.city;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.City;
import com.nasa.nafood.domain.repository.CityRepository;

@Service
public class DeleteCityService {

	@Autowired
	private CityRepository cityRepository;
	
	public void execute(Long cityId) {
		Optional<City> city = cityRepository.findById(cityId);
		
		if(city.isEmpty()) {
			throw new EntityNotFoundException(String.format("The city with %d is not found", cityId));
		}
		
		cityRepository.deleteById(cityId);
	}
	
}
