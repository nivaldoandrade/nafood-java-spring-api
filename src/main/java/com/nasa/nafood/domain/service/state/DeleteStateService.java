package com.nasa.nafood.domain.service.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityInUseException;
import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.repository.StateRepository;

@Service
public class DeleteStateService {

	@Autowired
	private StateRepository stateRepository;
	
	public void execute(long stateId) {
		try {
			stateRepository.delete(stateId);
		} catch (Exception e) {
			if(e instanceof EmptyResultDataAccessException) {
				throw new EntityNotFoundException(String.format("The state with %d is not found", stateId));
			}
			
			if(e instanceof DataIntegrityViolationException) {
				throw new EntityInUseException(String.format("the state with id %d is being used", stateId));
			}
		}
	}
}
