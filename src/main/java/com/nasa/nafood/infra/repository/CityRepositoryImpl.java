package com.nasa.nafood.infra.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nasa.nafood.domain.model.City;
import com.nasa.nafood.domain.repository.CityRepository;

@Component
public class CityRepositoryImpl implements CityRepository {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<City> index() {
		return manager.createQuery("from City", City.class)
				.getResultList();
	}

	@Override
	public City show(Long id) {
		return manager.find(City.class, id);
	}

	@Transactional
	@Override
	public City store(City city) {
		return manager.merge(city);
	}

	@Transactional
	@Override
	public City update(City city) {
		return manager.merge(city);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		City city = show(id);
		
		manager.remove(city);
	}

}
