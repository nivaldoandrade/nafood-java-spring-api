package com.nasa.nafood.domain.service.cookery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.model.Cookery;
import com.nasa.nafood.domain.repository.CookeryRepository;

@Service
public class FindByNameCookeryService {

	@Autowired
	private CookeryRepository cookeryRepository;
	
	public List<Cookery> execute(String name) {
		return cookeryRepository.findAllByNameContaining(name);
	}
} 
