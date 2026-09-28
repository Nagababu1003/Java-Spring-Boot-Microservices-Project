package com.ng.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ng.payment.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
