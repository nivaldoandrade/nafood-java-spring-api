package com.nasa.nafood.domain.service.cookery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.Cookery;
import com.nasa.nafood.domain.repository.CookeryRepository;

@Service
public class FindByIdCookeryService {

	private static final String MSG_COOKERY_NOT_FOUND = "The cookery with %d is not found";
	@Autowired
	private CookeryRepository cookeryRepository;
	
	public Cookery execute(Long cookeryId) {
		return cookeryRepository.findById(cookeryId).orElseThrow(() -> 
			new EntityNotFoundException(String.format(MSG_COOKERY_NOT_FOUND, cookeryId)));
	}
}
