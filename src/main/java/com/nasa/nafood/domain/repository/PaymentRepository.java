package com.nasa.nafood.domain.repository;

import java.util.List;

import com.nasa.nafood.domain.model.Payment;

public interface PaymentRepository {
	
	List<Payment> index();
	Payment show(Long id);
	Payment store(Payment payment);
	Payment update(Payment payment);
	void delete(Long id);

}
