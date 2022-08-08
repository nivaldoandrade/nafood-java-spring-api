package com.nasa.nafood.domain.jpa.restaurant;

import java.util.Optional;

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
		
		Optional<Restaurant> restaurantOptional = restaurantRepository.findById(1L);
		
		if(restaurantOptional.isEmpty()) {
			System.out.println("The restaurant is not found.");
			return;
		};
		
		Restaurant restaurant = restaurantOptional.get();
		
		System.out.printf("Restaurnt: %s - tax: %1.2f - cookery: %s \n", 
				restaurant.getName(), 
				restaurant.getFee(),
				restaurant.getCookery().getName()
		);
	}
}
