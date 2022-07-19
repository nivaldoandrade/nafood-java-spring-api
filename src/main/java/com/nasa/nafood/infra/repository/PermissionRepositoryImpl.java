package com.nasa.nafood.infra.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nasa.nafood.domain.model.Permission;
import com.nasa.nafood.domain.repository.PermissionRepository;

@Component
public class PermissionRepositoryImpl implements PermissionRepository {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Permission> index() {
		return manager.createQuery("from Permission", Permission.class)
				.getResultList();
	}

	@Override
	public Permission show(Long id) {
		return manager.find(Permission.class, id);
	}

	@Transactional
	@Override
	public Permission store(Permission permission) {
		return manager.merge(permission);
	}
	
	@Transactional
	@Override
	public Permission update(Permission permission) {
		return manager.merge(permission);
	}
	
	@Transactional
	@Override
	public void delete(Long id) {
		Permission permission = show(id);
		
		manager.remove(permission);
	}
	
	
}
