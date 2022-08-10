package com.nasa.nafood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.nasa.nafood.infra.repository.CustomRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomRepositoryImpl.class)
public class NafoodApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NafoodApiApplication.class, args);
	}

}
