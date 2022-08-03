package com.nasa.nafood.domain.service.cookery;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.Cookery;
import com.nasa.nafood.domain.repository.CookeryRepository;

@Service
public class ShowCookeryService {

	@Autowired
	private CookeryRepository cookeryRepository;
	
	public Cookery execute(Long id) {
		Optional<Cookery> cookery = cookeryRepository.findById(id);
		
		if(cookery.isEmpty()) {
			throw new EntityNotFoundException(String.format("The cookery with %d is not found", id));
		}
		
		return cookery.get();
	}
}
