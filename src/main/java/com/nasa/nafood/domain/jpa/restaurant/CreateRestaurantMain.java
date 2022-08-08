package com.nasa.nafood.domain.jpa.restaurant;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.nasa.nafood.NafoodApiApplication;
import com.nasa.nafood.domain.model.Restaurant;
import com.nasa.nafood.domain.repository.RestaurantRepository;

public class CreateRestaurantMain {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(NafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestaurantRepository restaurantRepository = applicationContext.getBean(RestaurantRepository.class);
		
		Restaurant restaurant1 = new Restaurant();
		restaurant1.setName("Bob's");
		restaurant1.setFee(new BigDecimal(50.0));
		
		Restaurant restaurant2 = new Restaurant();
		restaurant2.setName("Ziza");
		restaurant2.setFee(new BigDecimal(89.54));
		
		
		Restaurant restaurnt1 = restaurantRepository.save(restaurant1);
		Restaurant restaurnt2 = restaurantRepository.save(restaurant2);
		
		System.out.printf("Restaurant: %s - tax: %1.2f\n", restaurnt1.getName(), restaurnt1.getFee());
		System.out.printf("Restaurant: %s - tax: %1.2f\n", restaurnt2.getName(), restaurnt2.getFee());
		
	}
}
