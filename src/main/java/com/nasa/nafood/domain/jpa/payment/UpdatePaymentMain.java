package com.nasa.nafood.domain.jpa.payment;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.nasa.nafood.NafoodApiApplication;
import com.nasa.nafood.domain.model.Payment;
import com.nasa.nafood.domain.repository.PaymentRepository;

public class UpdatePaymentMain {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(NafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		PaymentRepository paymentRepository = applicationContext.getBean(PaymentRepository.class);
		
		
		Payment payment = paymentRepository.show(1L);
		payment.setDescription("Pix");

		payment = paymentRepository.store(payment);
		
		System.out.printf("id: %d - payment: %s%n", payment.getId(), payment.getDescription());
	}
}
