package com.nasa.nafood.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomRepository<T, ID> extends JpaRepository<T, ID> {
	
	Optional<T> findFirst();
}
