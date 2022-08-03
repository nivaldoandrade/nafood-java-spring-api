package com.nasa.nafood.domain.jpa.payment;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.nasa.nafood.NafoodApiApplication;
import com.nasa.nafood.domain.model.Payment;
import com.nasa.nafood.domain.repository.PaymentRepository;

public class ListPaymentMain {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(NafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		PaymentRepository paymentRepository = applicationContext.getBean(PaymentRepository.class);
		
		
		List<Payment> payments = paymentRepository.findAll();
		
		for(Payment payment: payments) {
			System.out.println(payment.getDescription());
		}
	}
}
