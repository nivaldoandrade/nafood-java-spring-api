package com.nasa.nafood.domain.service.cookery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.CookeryNotFoundException;
import com.nasa.nafood.domain.model.Cookery;
import com.nasa.nafood.domain.repository.CookeryRepository;

@Service
public class FindByIdCookeryService {

	@Autowired
	private CookeryRepository cookeryRepository;
	
	public Cookery execute(Long cookeryId) {
		return cookeryRepository.findById(cookeryId).orElseThrow(() -> 
			new CookeryNotFoundException(cookeryId));
	}
}
