package com.abdul.ecommerce.payment.mapper;

import com.abdul.ecommerce.payment.document.Payment;
import com.abdul.toolkit.utils.customer.dto.PaymentRequest;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public Payment mapToPayment(PaymentRequest paymentRequest) {
        return Payment.builder()
                .id(paymentRequest.id())
                .amount(paymentRequest.amount())
                .orderId(paymentRequest.orderId())
                .customerId(paymentRequest.customer().id())
                .paymentMethod(paymentRequest.paymentMethod())
                .build();
    }
}
