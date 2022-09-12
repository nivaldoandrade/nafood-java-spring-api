package com.nasa.nafood.domain.service.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.model.State;

@Service
public class ShowStateService {

	@Autowired
	private FindByIdStateService findByIdStateService;
	
	public State execute(Long stateId) {
		return findByIdStateService.execute(stateId);
	 
	}
}
