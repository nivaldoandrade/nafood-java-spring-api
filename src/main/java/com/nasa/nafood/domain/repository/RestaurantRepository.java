package com.nasa.nafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.infra.repository.CustomRestaurantRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>, CustomRestaurantRepository {
	
	List<Restaurant> findByFeeBetween(BigDecimal initialFee, BigDecimal finalFee);
	
//	@Query("from Restaurant where name like %:name% and cookery.id = :id")
	List<Restaurant> findByNameAndCookeryId(String name, @Param("id") Long cookery);
	
//	List<Restaurant> findByNameContainingAndCookeryId(String name, Long cookery);
	
	Optional<Restaurant> findFirstByNameContaining(String name);
	
	List<Restaurant> findTop2ByNameContaining(String name);
	
	int countByCookeryId(long cookeryId);
}
