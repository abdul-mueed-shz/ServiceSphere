package com.abdul.ecommerce.payment.service;

import com.abdul.ecommerce.payment.dto.PaymentRequest;
import com.abdul.ecommerce.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public String createPayment(PaymentRequest paymentRequest) {
        return paymentRepository.createPayment(paymentRequest);
    }
}
