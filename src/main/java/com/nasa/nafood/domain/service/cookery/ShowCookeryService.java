package com.nasa.nafood.domain.service.cookery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.model.Cookery;

@Service
public class ShowCookeryService {

	@Autowired
	private FindByIdCookeryService findByIdCookeryService;
	
	public Cookery execute(Long cookeryId) {
		return findByIdCookeryService.execute(cookeryId);
	
	}
}
