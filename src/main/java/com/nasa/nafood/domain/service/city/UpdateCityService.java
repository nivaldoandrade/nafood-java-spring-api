package com.nasa.nafood.domain.service.city;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.model.City;
import com.nasa.nafood.domain.model.State;
import com.nasa.nafood.domain.repository.CityRepository;
import com.nasa.nafood.domain.service.state.FindByIdStateService;

@Service
public class UpdateCityService {

	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private FindByIdCityService findByIdCityService;
	
	@Autowired
	private FindByIdStateService findByIdStateService;
	
	public City execute(Long cityId, City city) {
		City cityUpdate = findByIdCityService.execute(cityId);
		
		if(city.getState() == null || city.getState().getId() == null) {
			throw new EntityBadRequestException("The state is required and not null");
		}
		
		Long stateId = city.getState().getId();
		
		State state = findByIdStateService.execute(stateId);
		
		cityUpdate.setState(state);
		
		BeanUtils.copyProperties(city, cityUpdate, "id", "state");
		
		return cityRepository.save(cityUpdate);	
	}
	
}
