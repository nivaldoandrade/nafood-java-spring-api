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
	private FindByIdStateService findByIdStateService;
	
	@Autowired
	private FindByIdCityService findByIdCityService;
	
	public City execute(Long cityId, City city) {
		
		City cityUpdate = findByIdCityService.execute(cityId);
		
		BeanUtils.copyProperties(city, cityUpdate, "id");
		
		if(cityUpdate.getState() == null || cityUpdate.getState().getId() == null) {
			throw new EntityBadRequestException("The state is required and not null");
		}
		
		Long stateId = cityUpdate.getState().getId();
		
		State state = findByIdStateService.execute(stateId);
		
		cityUpdate.setState(state);
		
		return cityRepository.save(cityUpdate);	
	}
	
}
