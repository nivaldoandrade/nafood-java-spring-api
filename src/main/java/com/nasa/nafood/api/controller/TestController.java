package com.nasa.nafood.api.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.domain.model.Cookery;
import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.repository.CookeryRepository;
import com.nasa.nafood.domain.repository.RestaurantRepository;

@RestController
@RequestMapping("/tests")
public class TestController {

	
	@Autowired
	private CookeryRepository cookeryRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@GetMapping("/name/all")
	public List<Cookery> findAllByName(String name) {
		return cookeryRepository.findAllByNameContaining(name);
	}
	
	@GetMapping("/name")
	public Cookery findByName(String name) {
		return cookeryRepository.findByName(name);
	}
	
	@GetMapping("/cookery/per-name-exists")
	public boolean existsByName(String name) {
		return cookeryRepository.existsByName(name);
	}
	 
	@GetMapping("/restaurant/per-fee") 
	public List<Restaurant> findByFeeBetween(BigDecimal initialFee, BigDecimal finalFee) {
		return restaurantRepository.findByFeeBetween(initialFee, finalFee);
	}
	
	@GetMapping("/restaurant/per-name-and-coookery")
	public List<Restaurant> findByNameContainingAndCookeryId(String name, Long cookeryId) {
		return restaurantRepository.findByNameAndCookeryId(name, cookeryId);
	}
	
	@GetMapping("/restaurant/per-name-first") 
	public Optional<Restaurant> findFisrtByNameContaining(String name) {
		return restaurantRepository.findFirstByNameContaining(name);
	}
	
	@GetMapping("/restaurant/per-name-top2") 
	public List<Restaurant> findTop2ByNameContaining(String name) {
		return restaurantRepository.findTop2ByNameContaining(name);
	}
	
	@GetMapping("/restaurant/count-per-cookery")
	public int restaurantCountByCookery(Long cookeryId) {
		return restaurantRepository.countByCookeryId(cookeryId);
	} 
	
	@GetMapping("/restaurant/per-name-between-fee") 
	public List<Restaurant> findByNameBetweenFee(String name, BigDecimal initialFee, BigDecimal finalFee) {
		return restaurantRepository.findByNameBetweenFee(name, initialFee, finalFee);
	}
}
