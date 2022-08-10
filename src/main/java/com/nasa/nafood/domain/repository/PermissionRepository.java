package com.nasa.nafood.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nasa.nafood.domain.model.Permission;

@Repository
public interface PermissionRepository {

	List<Permission> index();
	Permission show(Long id);
	Permission store(Permission permission);
	Permission update(Permission permission);
	void delete(Long id);
}
