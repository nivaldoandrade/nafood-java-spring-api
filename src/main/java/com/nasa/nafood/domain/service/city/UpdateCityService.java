package com.nasa.nafood.domain.service.city;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.City;
import com.nasa.nafood.domain.model.State;
import com.nasa.nafood.domain.repository.CityRepository;
import com.nasa.nafood.domain.repository.StateRepository;

@Service
public class UpdateCityService {

	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	public City execute(Long cityId, City city) {
		Optional<City> cityOptional = cityRepository.findById(cityId);
		
		if(cityOptional.isEmpty()) {
			throw new EntityNotFoundException(String.format("The city with %d is not found", cityId));
		};
		
		Long stateId = city.getState().getId();
		Optional<State> stateOptinal = stateRepository.findById(stateId);
		
		if(stateOptinal.isEmpty()) {
			throw new EntityBadRequestException(String.format("The state with %d is not found", stateId));
		};
		
		State state = stateOptinal.get();
		City cityUpdate = cityOptional.get();
		
		cityUpdate.setState(state);
		
		BeanUtils.copyProperties(city, cityUpdate, "id", "state");
		
		return cityRepository.save(cityUpdate);	
	}
	
}
