package com.nasa.nafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nasa.nafood.domain.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

//	List<State> index();
//	State show(Long id);
//	State store(State state);
//	State update(State state);
//	void delete(Long id);
}
