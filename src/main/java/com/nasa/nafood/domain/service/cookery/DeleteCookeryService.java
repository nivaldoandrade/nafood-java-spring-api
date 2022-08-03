package com.nasa.nafood.domain.service.cookery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityInUseException;
import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.repository.CookeryRepository;

@Service
public class DeleteCookeryService {
	
	@Autowired
	private CookeryRepository cookeryRepository;
	
	public void execute(Long id) {
		
		try {
			cookeryRepository.deleteById(id);
			
		} catch (Exception e) {
			
			if(e instanceof EmptyResultDataAccessException) {
				throw new EntityNotFoundException(String.format("the cookery with id %d is not found", id));
			} else if(e instanceof DataIntegrityViolationException) {
				throw new EntityInUseException(String.format("the cookery with id %d is being used", id));
			}
		} 
	}
}
