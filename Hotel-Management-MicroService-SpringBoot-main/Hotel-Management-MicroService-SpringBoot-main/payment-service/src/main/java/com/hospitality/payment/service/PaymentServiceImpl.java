package com.hospitality.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitality.payment.entity.Payment;
import com.hospitality.payment.model.PaymentDto;
import com.hospitality.payment.repository.PaymentRepository;
import com.hospitality.payment.utility.PaymentUtility;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;

	public Payment addPayment(PaymentDto paymentDto) {
		return paymentRepository.save(new PaymentUtility().convert(paymentDto));
	}
}
