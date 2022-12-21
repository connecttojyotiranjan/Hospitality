package com.hospitality.payment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospitality.payment.entity.Payment;
import com.hospitality.payment.model.PaymentDto;

@RequestMapping("/v1/api")
public interface PaymentController {

	@PostMapping("/payments")
	public ResponseEntity<Payment> addPayment(PaymentDto paymentDto);

}
