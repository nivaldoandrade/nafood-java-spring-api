package com.nasa.nafood.infra.repository;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.nasa.nafood.domain.repository.CustomRepository;

public class CustomRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements CustomRepository<T, ID>{
	
	private EntityManager entityManager;

	public CustomRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		
		this.entityManager = entityManager;
	}
	
	public Optional<T> findFirst() {
		var jpql = "from " + getDomainClass().getName();
		
		T entity = entityManager.createQuery(jpql, getDomainClass())
			.setMaxResults(1)
			.getSingleResult();
		
		return Optional.ofNullable(entity);
	}

}
