package com.hospitality.payment.utility;

import com.hospitality.payment.entity.Payment;
import com.hospitality.payment.model.PaymentDto;

public interface Converter {
   public Payment convert(PaymentDto paymentDto);
}