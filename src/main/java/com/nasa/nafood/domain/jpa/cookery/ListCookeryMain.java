package com.nasa.nafood.domain.jpa.cookery;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.nasa.nafood.NafoodApiApplication;
import com.nasa.nafood.domain.model.Cookery;
import com.nasa.nafood.domain.repository.CookeryRepository;

public class ListCookeryMain {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(NafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CookeryRepository cookeryRepository = applicationContext.getBean(CookeryRepository.class);
		
		List<Cookery> cookeries = cookeryRepository.findAll();
		
		for(Cookery cookery : cookeries) {
			System.out.println(cookery.getName());
		}
		
	}
}
