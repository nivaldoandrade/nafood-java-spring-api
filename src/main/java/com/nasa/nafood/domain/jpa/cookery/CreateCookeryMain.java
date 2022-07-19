package com.nasa.nafood.domain.jpa.cookery;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.nasa.nafood.NafoodApiApplication;
import com.nasa.nafood.domain.model.Cookery;
import com.nasa.nafood.domain.repository.CookeryRepository;

public class CreateCookeryMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =  new SpringApplicationBuilder(NafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CookeryRepository cookeryRepository = applicationContext.getBean(CookeryRepository.class);
		
		Cookery cookery1 = new Cookery();
		
		cookery1.setName("Japonesa");
		
		Cookery cookery2 = new Cookery();
		
		cookery2.setName("Russa");
		
		cookery1 = cookeryRepository.store(cookery1);
		cookery2 = cookeryRepository.store(cookery2);
		
		System.out.printf("%d - %s\n", cookery1.getId(), cookery1.getName());
		System.out.printf("%d - %s\n", cookery2.getId(), cookery2.getName());
	}
}
