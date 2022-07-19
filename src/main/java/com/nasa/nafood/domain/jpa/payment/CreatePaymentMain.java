package com.nasa.nafood.domain.jpa.payment;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.nasa.nafood.NafoodApiApplication;
import com.nasa.nafood.domain.model.Payment;
import com.nasa.nafood.domain.repository.PaymentRepository;

public class CreatePaymentMain {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(NafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		PaymentRepository paymentRepository = applicationContext.getBean(PaymentRepository.class);
		
		
		Payment payment1 = new Payment();
		payment1.setDescription("Checks");
		
		Payment payment2 = new Payment();
		payment2.setDescription("Pix");
		
		payment1 = paymentRepository.store(payment1);
		
		payment2 = paymentRepository.store(payment2);
		
		System.out.printf("Payment: %s%n", payment1.getDescription());
		System.out.printf("Payment: %s%n", payment2.getDescription());
	}
}
