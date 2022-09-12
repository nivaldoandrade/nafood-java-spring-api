package com.nasa.nafood.domain.service.cookery;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.nafood.domain.exception.EntityBadRequestException;
import com.nasa.nafood.domain.model.Cookery;
import com.nasa.nafood.domain.repository.CookeryRepository;

@Service
public class UpdateCookeryService {

	@Autowired
	private CookeryRepository cookeryRepository;
	
	@Autowired
	private FindByIdCookeryService findByIdCookeryService;
	
	public Cookery execute(Long cookeryId, Cookery cookery) {
		if(cookery.getName() == null) {
			throw new EntityBadRequestException("The name field is required and not null");
		} 
		
		Cookery cookeryUpdated = findByIdCookeryService.execute(cookeryId);
		
		BeanUtils.copyProperties(cookery, cookeryUpdated, "id");
		
		return cookeryRepository.save(cookeryUpdated);
	}
}
