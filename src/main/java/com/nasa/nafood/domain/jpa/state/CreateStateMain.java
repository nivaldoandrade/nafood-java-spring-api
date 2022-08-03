package com.nasa.nafood.domain.jpa.state;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.nasa.nafood.NafoodApiApplication;
import com.nasa.nafood.domain.model.State;
import com.nasa.nafood.domain.repository.StateRepository;

public class CreateStateMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(NafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		StateRepository stateRepository = applicationContext.getBean(StateRepository.class);
		
		State state = new State();
		state.setName("Piauí");
		
		state = stateRepository.save(state);
		
		System.out.printf("Id: %d - State: %s%n", state.getId(), state.getName());
	}
}
