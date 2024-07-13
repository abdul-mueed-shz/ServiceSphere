package com.abdul.ecommerce.payment.repository;

import com.abdul.ecommerce.payment.dto.PaymentRequest;

public interface PaymentRepository {

    String createPayment(PaymentRequest paymentRequest);
}
