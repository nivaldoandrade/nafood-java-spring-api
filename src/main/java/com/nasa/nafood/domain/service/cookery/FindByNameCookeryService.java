package com.nasa.nafood.domain.service.cookery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.Cookery;
import com.nasa.nafood.domain.repository.CookeryRepository;

@Service
public class FindByNameCookeryService {

	@Autowired
	private CookeryRepository cookeryRepository;
	
	public List<Cookery> execute(String name) {
		List<Cookery> cookeries =  cookeryRepository.findAllByNameContaining(name);
		
		
		if(cookeries.isEmpty()) {
			throw new EntityNotFoundException(String.format("The cookery with %s is not found", name));
		}
		
		return cookeries;
	}
} 
