package com.nasa.nafood.infra.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nasa.nafood.domain.model.State;
import com.nasa.nafood.domain.repository.StateRepository;

@Component
public class StateRepositoryImpl implements StateRepository  {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<State> index() {
		return manager.createQuery("from State", State.class)
				.getResultList();
	}

	@Override
	public State show(Long id) {
		return manager.find(State.class, id);
	}

	@Transactional
	@Override
	public State store(State state) {
		return manager.merge(state);
	}

	@Transactional
	@Override
	public State update(State state) {
		return manager.merge(state);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		State state = show(id);
		
		if(state == null) {
			throw new EmptyResultDataAccessException(1);
		};
		
		manager.remove(state);
	}
}
