package com.nasa.nafood.domain.jpa.city;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.nasa.nafood.NafoodApiApplication;
import com.nasa.nafood.domain.model.City;
import com.nasa.nafood.domain.model.State;
import com.nasa.nafood.domain.repository.CityRepository;
import com.nasa.nafood.domain.repository.StateRepository;

public class UpdateCityMain {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(NafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CityRepository cityRepository = applicationContext.getBean(CityRepository.class);
		StateRepository stateRepository = applicationContext.getBean(StateRepository.class);
		
		State state = stateRepository.show(1L);
		
		City city = cityRepository.show(2L);
		city.setName("São Roque");
		city.setState(state);
		
		city = cityRepository.update(city);

		System.out.printf("Id: %d - City: %s - State: %s%n", city.getId(), city.getName(), city.getState().getName());
	
	}
}
