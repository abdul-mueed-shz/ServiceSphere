package com.abdul.ecommerce.payment.service;

import com.abdul.ecommerce.payment.dto.PaymentConfirmation;
import com.abdul.ecommerce.payment.messaging.PaymentProducer;
import com.abdul.toolkit.utils.customer.dto.PaymentRequest;
import com.abdul.ecommerce.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentProducer  paymentProducer;

    public String createPayment(PaymentRequest paymentRequest) {
        String paymentId = paymentRepository.createPayment(paymentRequest);
        paymentProducer.sendPaymentConfirmation(
                PaymentConfirmation.builder()
                        .paymentMethod(paymentRequest.paymentMethod())
                        .amount(paymentRequest.amount())
                        .customerEmail(paymentRequest.customer().email())
                        .customerFirstName(paymentRequest.customer().firstName())
                        .customerLastName(paymentRequest.customer().lastName())
                        .orderId(paymentRequest.orderId())
                        .build()
        );
        return paymentId;
    }
}
