package com.ng.payment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ng.payment.entity.Payment;
import com.ng.payment.repository.PaymentRepository;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

	@Mock
	private PaymentRepository paymentRepo;
	
	@InjectMocks
	private PaymentService paymentService;
	
	@Test
	void makePayment_shouldsavePayment() {
		Payment payment =new Payment();
		payment.setId(1L);
		
		
		when(paymentRepo.save(payment)).thenReturn(payment);
		
		Payment result=paymentService.makePayment(payment);
		assertNotNull(result);
		assertEquals(1L,result.getId());
		
	}
	
	@Test
	void getPayments_shouldReturnAllPayments() {
		Payment payment1=new Payment();
		payment1.setId(1L);
		Payment payment2=new Payment();
		payment2.setId(2L);
		List<Payment> payments=new ArrayList<>();
		payments.add(payment1);
		payments.add(payment2);
		when(paymentRepo.findAll()).thenReturn(payments);
		
		
		List<Payment> result=paymentService.getPayments();
		assertNotNull(result);
		assertEquals(2,result.size());
		assertEquals(1L,result.get(0).getId());
		assertEquals(2L,result.get(1).getId());
		
	}
	
	
}
