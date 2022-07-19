package com.nasa.nafood.domain.service.cookery;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.Cookery;
import com.nasa.nafood.domain.repository.CookeryRepository;

@Service
public class UpdateCookeryService {

	@Autowired
	private CookeryRepository cookeryRepository;
	
	public Cookery execute(Long id, Cookery cookery) {
		Cookery cookeryUpdate = cookeryRepository.show(id);
		
		if(cookeryUpdate == null) {
			throw new EntityNotFoundException(String.format("The cookery with %d is not found", id));
		};
		
		BeanUtils.copyProperties(cookery, cookeryUpdate, "id");
		
		return cookeryRepository.update(cookeryUpdate);
	}
}
