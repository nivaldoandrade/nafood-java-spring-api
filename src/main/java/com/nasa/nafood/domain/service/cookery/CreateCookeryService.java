package com.nasa.nafood.domain.service.cookery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.model.Cookery;
import com.nasa.nafood.domain.repository.CookeryRepository;

@Service
public class CreateCookeryService {
	
	@Autowired
	private CookeryRepository cookeryRepository;
	
	public Cookery execute(Cookery cookery) {
		return cookeryRepository.store(cookery);
	}
}
