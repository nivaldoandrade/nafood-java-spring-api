package com.nasa.nafood.infra.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Restaurant> criteria = builder.createQuery(Restaurant.class);
		
		Root<Restaurant> root = criteria.from(Restaurant.class); // "FROM Restaurant"
		
		List<Predicate> predicates = new ArrayList<>();
		
		if(StringUtils.hasLength(name)) {
			predicates.add(builder.like(root.get("name"), "%" + name + "%"));
		}
		
		if(initialFee != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("fee"), initialFee));
		}
		
		if(finalFee != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get("fee"), finalFee));
		}
		
		
		criteria.where(predicates.toArray(new Predicate[0]));
		
		TypedQuery<Restaurant> query = entityManager.createQuery(criteria);
		
		return query.getResultList();
	}
	
//	@Override
//	public List<Restaurant> findByNameBetweenFee(String name, BigDecimal initialFee, BigDecimal finalFee) {
////		var jpql = "FROM Restaurant "
////				+ "WHERE name LIKE :name "
////				+ "AND fee BETWEEN :initialFee AND :finalFee";
//		
//		Map<String, Object> parameters = new HashMap<String, Object>();
//		
//		var jpql = new StringBuilder();
//		
//		jpql.append("FROM Restaurant where 0=0 ");
//		
//		if(StringUtils.hasLength(name)) {
//			jpql.append("and name LIKE :name ");
//			parameters.put("name", "%" + name + "%");
//		}
//		
//		if(initialFee != null) {
//			jpql.append("and fee >= :initialFee ");
//			parameters.put("initialFee", initialFee);
//		}
//		
//		if(finalFee != null) {
//			jpql.append("and fee <= :finalFee");
//			parameters.put("finalFee", finalFee);
//		}
//		
//		TypedQuery<Restaurant> query = entityManager.createQuery(jpql.toString(), Restaurant.class);
//		
//		
//		
//		parameters.forEach((key, value) -> {
//			query.setParameter(key, value);
//		});
//		
//		return query.getResultList();
//	}
}
