package com.nasa.nafood.domain.service.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityInUseException;
import com.nasa.nafood.domain.repository.CityRepository;

@Service
public class DeleteCityService {

	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private FindByIdCityService findByIdCityService;
	
	public void execute(Long cityId) {
		findByIdCityService.execute(cityId);
		
		try {
			cityRepository.deleteById(cityId);
		}  catch (DataIntegrityViolationException e) {
			throw new EntityInUseException(String.format("The city with %d is being used", cityId));
		}
		
	}
	
}
