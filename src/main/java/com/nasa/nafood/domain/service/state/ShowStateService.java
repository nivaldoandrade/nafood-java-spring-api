package com.nasa.nafood.domain.service.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.State;
import com.nasa.nafood.domain.repository.StateRepository;

@Service
public class ShowStateService {

	@Autowired
	private StateRepository stateRepository;
	
	public State execute(Long stateId) {
		State state = stateRepository.show(stateId);
	 
		 if(state == null) {
			 throw new EntityNotFoundException(String.format("The state with %d is not found", stateId));
		 };
		 
		 return state;
	}
}
