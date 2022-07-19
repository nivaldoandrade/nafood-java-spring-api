package com.nasa.nafood.domain.jpa.permission;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.nasa.nafood.NafoodApiApplication;
import com.nasa.nafood.domain.model.Permission;
import com.nasa.nafood.domain.repository.PermissionRepository;

public class ListPermissionMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(NafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		PermissionRepository permissionRepository = applicationContext.getBean(PermissionRepository.class);
		
		List<Permission> permissions = permissionRepository.index();
		
		for(Permission permission : permissions) {
			System.out.printf("Id: %d - Permission: %s%n", permission.getId(), permission.getDescription());
		}
	}
}
