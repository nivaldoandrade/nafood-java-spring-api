package com.nasa.nafood.domain.repository;

import java.util.List;

import com.nasa.nafood.domain.model.City;

public interface CityRepository {

	List<City> index();
	City show(Long id);
	City store(City city);
	City update(City city);
	void delete(Long id);
}
