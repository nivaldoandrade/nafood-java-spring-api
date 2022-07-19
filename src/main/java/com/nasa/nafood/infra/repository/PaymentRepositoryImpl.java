package com.nasa.nafood.infra.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nasa.nafood.domain.model.Payment;
import com.nasa.nafood.domain.repository.PaymentRepository;

@Component
public class PaymentRepositoryImpl implements PaymentRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Payment> index() {
		return manager.createQuery("from Payment", Payment.class)
				.getResultList();
	}

	@Override
	public Payment show(Long id) {
		return manager.find(Payment.class, id);
	}

	@Transactional
	@Override
	public Payment store(Payment payment) {
		return manager.merge(payment);
	}
	
	@Transactional
	@Override
	public Payment update(Payment payment) {
		return manager.merge(payment);
	}
	
	@Transactional
	@Override
	public void delete(Long id) {
		Payment payment = show(id);
		
		manager.remove(payment);
	}
	
	
	
	
}
