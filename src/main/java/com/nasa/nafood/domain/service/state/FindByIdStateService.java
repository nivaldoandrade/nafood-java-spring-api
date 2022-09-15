package com.nasa.nafood.domain.service.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.StateNotFoundException;
import com.nasa.nafood.domain.model.State;
import com.nasa.nafood.domain.repository.StateRepository;

@Service
public class FindByIdStateService {
	
	@Autowired
	private StateRepository stateRepository;
	
	public State execute(Long stateId) {
		return stateRepository.findById(stateId).orElseThrow(() -> 
			new StateNotFoundException(stateId));
	}
}
