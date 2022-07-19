package com.nasa.nafood.domain.jpa.city;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.nasa.nafood.NafoodApiApplication;
import com.nasa.nafood.domain.model.City;
import com.nasa.nafood.domain.repository.CityRepository;

public class ListCityMain {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(NafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CityRepository cityRepository = applicationContext.getBean(CityRepository.class);
		
		List<City> cities = cityRepository.index();
		
		for(City city: cities) {
			System.out.printf("Id: %d - City: %s - State: %s%n", city.getId(), city.getName(), city.getState().getName());
		}
	}
}
