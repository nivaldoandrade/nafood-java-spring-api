package com.nasa.nafood.domain.service.state;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.model.State;
import com.nasa.nafood.domain.repository.StateRepository;

@Service
public class UpdateStateService {

	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private FindByIdStateService findByIdStateService;
	
	public State execute(Long stateId, State state) {
		if(state.getName() == null) {
			throw new EntityBadRequestException("The name field is required and not null"); 
		}
		
		State stateUpdated = findByIdStateService.execute(stateId);

		BeanUtils.copyProperties(state, stateUpdated, "id");
		
		return stateRepository.save(stateUpdated);
	}
}
