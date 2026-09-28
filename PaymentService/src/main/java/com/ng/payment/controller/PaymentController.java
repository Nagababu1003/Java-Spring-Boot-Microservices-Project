package com.ng.payment.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ng.payment.entity.Payment;
import com.ng.payment.service.PaymentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	private final PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	
	@PostMapping
	public Payment makePayment(@Valid @RequestBody Payment payment) {
		return paymentService.makePayment(payment);
	}
	
	@GetMapping
	public List<Payment> getAllPayments(){
		return paymentService.getPayments();
	}
	
}
