package com.nasa.nafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nasa.nafood.domain.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

//	List<Payment> index();
//	Payment show(Long id);
//	Payment store(Payment payment);
//	Payment update(Payment payment);
//	void delete(Long id);

}
