package com.nasa.nafood.domain.repository;

import java.util.List;

import com.nasa.nafood.domain.model.Cookery;

public interface CookeryRepository {
	List<Cookery> index();
	Cookery show(Long id);
	Cookery store(Cookery cookery);
	Cookery update(Cookery cookery);
	void delete(Long id);
}
