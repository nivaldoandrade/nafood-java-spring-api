package com.nasa.nafood.domain.service.cookery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.model.Cookery;
import com.nasa.nafood.domain.repository.CookeryRepository;

@Service
public class CreateCookeryService {
	
	@Autowired
	private CookeryRepository cookeryRepository;
	
	public Cookery execute(Cookery cookery) {
		if(cookery.getName() == null) {
			throw new EntityBadRequestException("The name field is required and not null");
		} 
		
		return cookeryRepository.save(cookery);
	}
}
