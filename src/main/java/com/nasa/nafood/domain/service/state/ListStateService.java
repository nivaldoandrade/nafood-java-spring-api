package com.nasa.nafood.domain.service.state;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.model.State;
import com.nasa.nafood.domain.repository.StateRepository;

@Service
public class ListStateService {

	@Autowired
	private StateRepository stateRepository;
	
	public List<State> execute() {
		return stateRepository.findAll();
	}
}
