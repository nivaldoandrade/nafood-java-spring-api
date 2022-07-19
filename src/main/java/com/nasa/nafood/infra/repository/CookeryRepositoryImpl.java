package com.nasa.nafood.infra.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nasa.nafood.domain.model.Cookery;
import com.nasa.nafood.domain.repository.CookeryRepository;

@Component
public class CookeryRepositoryImpl implements CookeryRepository {
	
	@PersistenceContext
	private EntityManager manager;
	

	@Override
	public List<Cookery> index() {
		return manager.createQuery("from Cookery", Cookery.class)
				.getResultList();
	}

	@Override
	public Cookery show(Long id) {
		return manager.find(Cookery.class, id);
	}

	@Transactional
	@Override
	public Cookery store(Cookery cookery) {
		return manager.merge(cookery);
	}

	@Transactional
	@Override
	public Cookery update(Cookery cookery) {
		return manager.merge(cookery);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Cookery cookery = show(id);
		
		if(cookery == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		manager.remove(cookery);	
	}

}
