package com.nasa.nafood.infra.repository;

import java.math.BigDecimal;
import java.util.List;

import com.nasa.nafood.domain.model.Restaurant;

public interface CustomRestaurantRepository {

	List<Restaurant> findByNameBetweenFee(String name, BigDecimal initialFee, BigDecimal finalFee);

}