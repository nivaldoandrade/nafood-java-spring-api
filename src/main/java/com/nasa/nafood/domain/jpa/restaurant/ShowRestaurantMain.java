package com.nasa.nafood.domain.jpa.restaurant;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.nasa.nafood.NafoodApiApplication;
import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.repository.RestaurantRepository;

public class ShowRestaurantMain {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(NafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestaurantRepository restaurantRepository = applicationContext.getBean(RestaurantRepository.class);
		
		Restaurant restaurant = restaurantRepository.show(1L);
		
		System.out.printf("Restaurnt: %s - tax: %1.2f - cookery: %s \n", 
				restaurant.getName(), 
				restaurant.getTax(),
				restaurant.getCookery().getName()
		);
	}
}
