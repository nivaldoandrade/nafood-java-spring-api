package com.nasa.nafood.domain.jpa.state;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.nasa.nafood.NafoodApiApplication;
import com.nasa.nafood.domain.repository.StateRepository;

public class DeleteStateMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(NafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		StateRepository stateRepository = applicationContext.getBean(StateRepository.class);
		

		stateRepository.delete(1L);
	}
}
