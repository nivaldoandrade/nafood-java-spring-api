package com.nasa.nafood.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nasa.nafood.domain.model.Cookery;

@Repository
public interface CookeryRepository extends CustomRepository<Cookery, Long> {

	List<Cookery> findAllByNameContaining(String name);
	
	Cookery findByName(String name);
	
	boolean existsByName(String name);
}
