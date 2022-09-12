package com.nasa.nafood.domain.service.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.model.City;
import com.nasa.nafood.domain.model.State;
import com.nasa.nafood.domain.repository.CityRepository;
import com.nasa.nafood.domain.service.state.FindByIdStateService;

@Service
public class CreateCityService {
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private FindByIdStateService findByIdStateService;
	
	public City execute(City city) {
		
		if(city.getState() == null || city.getState().getId() == null) {
			throw new EntityBadRequestException("The state cannot be null");
		}
		
		Long stateId = city.getState().getId();
		
		State state = findByIdStateService.execute(stateId);
		
		city.setState(state);
		
		return cityRepository.save(city);
	}
}
