package com.nasa.nafood.domain.service.city;

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
		City city = cityRepository.show(cityId);
		
		if(city == null) {
			throw new EntityNotFoundException(String.format("The city with %d is not found", cityId));
		}
		
		cityRepository.delete(cityId);
	}
	
}
