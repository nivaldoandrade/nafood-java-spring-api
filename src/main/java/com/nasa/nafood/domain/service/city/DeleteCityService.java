package com.nasa.nafood.domain.service.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityInUseException;
import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.repository.CityRepository;

@Service
public class DeleteCityService {

	@Autowired
	private CityRepository cityRepository;
	
	public void execute(Long cityId) {
		cityRepository.findById(cityId).orElseThrow(() -> 
			new EntityNotFoundException(String.format("The city with %d is not found", cityId))
		);
		
		try {
			cityRepository.deleteById(cityId);
		} catch (DataIntegrityViolationException e) {
			throw new EntityInUseException(String.format("The state with %d is being used", cityId));
		}
		
	}
	
}
