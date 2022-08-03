package com.nasa.nafood.domain.service.state;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.State;
import com.nasa.nafood.domain.repository.StateRepository;

@Service
public class UpdateStateService {

	@Autowired
	private StateRepository stateRepository;
	
	public State execute(Long stateId, State state) {
		Optional<State> stateOptional = stateRepository.findById(stateId);
		
		if(stateOptional.isEmpty()) {
			throw new EntityNotFoundException(String.format("The state with %d is not found", stateId));
		};
		
		State stateUpdate = stateOptional.get();
		
		BeanUtils.copyProperties(state, stateUpdate, "id");
		
		return stateRepository.save(stateUpdate);
	}
}
