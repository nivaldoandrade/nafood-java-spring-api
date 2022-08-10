package com.nasa.nafood.infra.repository.spec.restaurant;

import java.math.BigDecimal;

import org.springframework.data.jpa.domain.Specification;

import com.nasa.nafood.domain.model.Restaurant;

public class RestaurantSpecs {

	public static Specification<Restaurant> withSimilarName(String name) {
		return (root, query, builder) -> 
			builder.like(root.get("name"), "%" + name + "%");
	}
	
	public static Specification<Restaurant> withFreeFee() {
		return (root, query, builder) ->
			builder.equal(root.get("fee"), BigDecimal.ZERO);
	}
}
