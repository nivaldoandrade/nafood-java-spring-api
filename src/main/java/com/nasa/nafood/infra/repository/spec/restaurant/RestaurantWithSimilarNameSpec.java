package com.nasa.nafood.infra.repository.spec.restaurant;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.nasa.nafood.domain.model.Restaurant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RestaurantWithSimilarNameSpec implements Specification<Restaurant>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;

	@Override
	public Predicate toPredicate(Root<Restaurant> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		
		return builder.like(root.get("name"), "%" + name + "%");
	}

}
