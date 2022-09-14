package com.nasa.nafood.api.controller.city;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.City;
import com.nasa.nafood.domain.service.city.FindByIdCityService;
import com.nasa.nafood.domain.service.city.UpdateCityService;

@RestController
@RequestMapping("/cities/{cityId}")
public class UpdateCityController {
	
	@Autowired
	private UpdateCityService updateCityService;
	
	@Autowired
	private FindByIdCityService findByIdCityService;
	
	@PutMapping
	public City store(@PathVariable long cityId, @RequestBody City city) {
		City cityUpdate = findByIdCityService.execute(cityId);
		
		BeanUtils.copyProperties(city, cityUpdate, "id");
		
		try {
			return updateCityService.execute(cityId, cityUpdate);
		} catch (EntityNotFoundException e) {
			throw new EntityBadRequestException(e.getMessage());
		}
			
	}
}
