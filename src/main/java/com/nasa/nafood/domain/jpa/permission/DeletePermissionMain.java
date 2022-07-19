package com.nasa.nafood.domain.jpa.permission;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.nasa.nafood.NafoodApiApplication;
import com.nasa.nafood.domain.repository.PermissionRepository;

public class DeletePermissionMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(NafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		PermissionRepository permissionRepository = applicationContext.getBean(PermissionRepository.class);
		
		permissionRepository.delete(1L);
	}
}
