package com.nasa.nafood.infra.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.repository.RestaurantRepository;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Restaurant> index() {
		return manager.createQuery("from Restaurant", Restaurant.class)
		.getResultList();
	}

	@Override
	public Restaurant show(Long id) {
		return manager.find(Restaurant.class, id);
	}

	@Transactional
	@Override
	public Restaurant store(Restaurant restaurant) {
		return manager.merge(restaurant);
	}
	
	@Transactional
	@Override
	public Restaurant update(Restaurant restaurant) {
		return manager.merge(restaurant);
	}

	@Transactional
	@Override
	public void delete(Restaurant restaurant) {
		restaurant = show(restaurant.getId());
		manager.remove(restaurant);
	}
	
	
}
