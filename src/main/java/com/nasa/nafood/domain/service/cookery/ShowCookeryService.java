package com.nasa.nafood.domain.service.cookery;

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
		return cookeryRepository.findById(id).orElseThrow(() -> 
			new EntityNotFoundException(String.format("The cookery with %d is not found", id))
		);
	
	}
}
