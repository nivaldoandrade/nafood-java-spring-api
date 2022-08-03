package com.nasa.nafood.domain.service.city;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.model.City;
import com.nasa.nafood.domain.model.State;
import com.nasa.nafood.domain.repository.CityRepository;
import com.nasa.nafood.domain.repository.StateRepository;

@Service
public class CreateCityService {
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	public City execute(City city) {
		Long stateId = city.getState().getId();
		
		Optional<State> stateOptinal = stateRepository.findById(stateId);
	
		if(stateOptinal.isEmpty()) {
			throw new EntityBadRequestException(String.format("The state with %d is not found", stateId));
		}
		
		State state = stateOptinal.get();
		
		city.setState(state);
		
		return cityRepository.save(city);
	}
}
