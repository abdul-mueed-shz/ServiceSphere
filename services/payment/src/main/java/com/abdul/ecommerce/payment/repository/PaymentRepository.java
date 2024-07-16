package com.abdul.ecommerce.payment.repository;

import com.abdul.toolkit.utils.customer.dto.PaymentRequest;

public interface PaymentRepository {

    String createPayment(PaymentRequest paymentRequest);
}
