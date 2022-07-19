package com.nasa.nafood.domain.jpa.restaurant;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.nasa.nafood.NafoodApiApplication;
import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.repository.RestaurantRepository;

public class IndexRestaurantMain {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(NafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestaurantRepository restaurantRepository = applicationContext.getBean(RestaurantRepository.class);
		
		List<Restaurant> restaurants = restaurantRepository.index();
		
		for(Restaurant restaurant: restaurants) {
			System.out.printf("Restaurnt: %s - tax: %1.2f - cookery: %s \n", 
					restaurant.getName(), 
					restaurant.getTax(),
					restaurant.getCookery().getName()
			);
		}
	}
}
