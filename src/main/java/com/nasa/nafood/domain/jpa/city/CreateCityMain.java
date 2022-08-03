package com.nasa.nafood.domain.jpa.city;

import java.util.Optional;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.nasa.nafood.NafoodApiApplication;
import com.nasa.nafood.domain.model.City;
import com.nasa.nafood.domain.model.State;
import com.nasa.nafood.domain.repository.CityRepository;
import com.nasa.nafood.domain.repository.StateRepository;

public class CreateCityMain {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(NafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CityRepository cityRepository = applicationContext.getBean(CityRepository.class);
		StateRepository stateRepository = applicationContext.getBean(StateRepository.class);
		
		Optional<State> stateOptional = stateRepository.findById(3L);
		
		if(stateOptional.isEmpty()) {
			System.out.println("The state is not found");
			return;
		}
		
		State state = stateOptional.get();
		
		City city = new City();
		city.setName("Floriano");
		city.setState(state);
		
		city = cityRepository.save(city);

		System.out.printf("Id: %d - City: %s - State: %s%n", city.getId(), city.getName(), city.getState().getName());
	
	}
}
