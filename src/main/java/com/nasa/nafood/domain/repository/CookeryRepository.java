package com.nasa.nafood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nasa.nafood.domain.model.Cookery;

public interface CookeryRepository extends JpaRepository<Cookery, Long> {

	List<Cookery> findAllByNameContaining(String name);
	
	Cookery findByName(String name);
	
	boolean existsByName(String name);
}
