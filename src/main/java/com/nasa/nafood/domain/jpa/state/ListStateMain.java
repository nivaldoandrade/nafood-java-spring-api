package com.nasa.nafood.domain.jpa.state;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.nasa.nafood.NafoodApiApplication;
import com.nasa.nafood.domain.model.State;
import com.nasa.nafood.domain.repository.StateRepository;

public class ListStateMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(NafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		StateRepository stateRepository = applicationContext.getBean(StateRepository.class);
		
		List<State> states = stateRepository.findAll();
		
		for(State state: states) {
			System.out.printf("Id: %d - State: %s%n", state.getId(), state.getName());
		};
	}
}
