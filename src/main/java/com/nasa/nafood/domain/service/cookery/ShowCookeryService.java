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
		Cookery cookery = cookeryRepository.show(id);
		
		if(cookery == null) {
			throw new EntityNotFoundException(String.format("The cookery with %d is not found", id));
		}
		
		return cookeryRepository.show(id);
	}
}
