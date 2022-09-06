package com.nasa.nafood.domain.service.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.model.State;
import com.nasa.nafood.domain.repository.StateRepository;

@Service
public class CreateStateService {

	@Autowired
	private StateRepository stateRepository;
	
	public State execute(State state) {
		
		if(state.getName() == null) {
			throw new EntityBadRequestException("The name field is required and not null"); 
		}
		
		return stateRepository.save(state);
	}
	
}
