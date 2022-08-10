package com.nasa.nafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nasa.nafood.domain.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

//	List<City> index();
//	City show(Long id);
//	City store(City city);
//	City update(City city);
//	void delete(Long id);
}
