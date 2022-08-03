package com.nasa.nafood.domain.service.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.model.City;
import com.nasa.nafood.domain.repository.CityRepository;

@Service
public class ListCityService {

	@Autowired
	private CityRepository cityRepository;
	
	public List<City> execute() {
		return cityRepository.findAll();
	}
}
