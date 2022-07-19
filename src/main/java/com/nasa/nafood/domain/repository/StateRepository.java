package com.nasa.nafood.domain.repository;

import java.util.List;

import com.nasa.nafood.domain.model.State;

public interface StateRepository {

	List<State> index();
	State show(Long id);
	State store(State state);
	State update(State state);
	void delete(Long id);
}
