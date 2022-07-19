package com.nasa.nafood.domain.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nasa.nafood.domain.model.Cookery;

@Component
public class CookeryJPA {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Cookery> list() {
		return manager.createQuery("from Cookery", Cookery.class)
				.getResultList();
	}
	
	public Cookery show(Long id) {
		return manager.find(Cookery.class, id);
	}
	
	@Transactional
	public Cookery save(Cookery cookery) {
		return manager.merge(cookery);
	}
	
	@Transactional
	public void remove(Cookery cookery) {
		cookery = show(cookery.getId());
		
		manager.remove(cookery);
	}

}
