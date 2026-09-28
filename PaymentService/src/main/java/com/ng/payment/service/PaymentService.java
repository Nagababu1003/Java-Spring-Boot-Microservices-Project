package com.ng.payment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ng.payment.entity.Payment;
import com.ng.payment.repository.PaymentRepository;

@Service
public class PaymentService {

	private final PaymentRepository paymentRepo;

	public PaymentService(PaymentRepository paymentRepo) {
		this.paymentRepo = paymentRepo;
	}
	
	
	public Payment makePayment(Payment payment) {
		payment.setStatus("SUCCESS");
		return paymentRepo.save(payment);
	}
	
	
	public List<Payment> getPayments(){
		return paymentRepo.findAll();
	}
	
	
}
