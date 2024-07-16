package com.abdul.toolkit.utils.payment.service;

import com.abdul.toolkit.client.PaymentClient;
import com.abdul.toolkit.utils.customer.dto.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentFeignService {

    private final PaymentClient paymentClient;

    public String createPayment(PaymentRequest paymentRequest) {
        return paymentClient.createPayment(paymentRequest).getBody();
    }
}
