package com.nasa.nafood.domain.service.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.State;
import com.nasa.nafood.domain.repository.StateRepository;

@Service
public class FindByIdStateService {

	private static final String MSG_STATE_NOT_FOUND = "The state with %d is not found";
	
	@Autowired
	private StateRepository stateRepository;
	
	public State execute(Long stateId) {
		return stateRepository.findById(stateId).orElseThrow(() -> 
			new EntityNotFoundException(String.format(MSG_STATE_NOT_FOUND, stateId)));
	}
}
