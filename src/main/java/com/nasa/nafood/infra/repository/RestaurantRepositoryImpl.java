package com.nasa.nafood.infra.repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.nasa.nafood.domain.model.Restaurant;


@Repository
public class RestaurantRepositoryImpl implements CustomRestaurantRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Restaurant> findByNameBetweenFee(String name, BigDecimal initialFee, BigDecimal finalFee) {
//		var jpql = "FROM Restaurant "
//				+ "WHERE name LIKE :name "
//				+ "AND fee BETWEEN :initialFee AND :finalFee";
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		var jpql = new StringBuilder();
		
		jpql.append("FROM Restaurant where 0=0 ");
		
		if(StringUtils.hasLength(name)) {
			jpql.append("and name LIKE :name ");
			parameters.put("name", "%" + name + "%");
		}
		
		if(initialFee != null) {
			jpql.append("and fee >= :initialFee ");
			parameters.put("initialFee", initialFee);
		}
		
		if(finalFee != null) {
			jpql.append("and fee <= :finalFee");
			parameters.put("finalFee", finalFee);
		}
		
		TypedQuery<Restaurant> query = entityManager.createQuery(jpql.toString(), Restaurant.class);
		
		
		
		parameters.forEach((key, value) -> {
			query.setParameter(key, value);
		});
		
		return query.getResultList();
	}
}
