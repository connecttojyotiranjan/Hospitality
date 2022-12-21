package com.hospitality.payment.service;

import com.hospitality.payment.entity.Payment;
import com.hospitality.payment.model.PaymentDto;

public interface PaymentService {

	public Payment addPayment(PaymentDto paymentDto);

}
