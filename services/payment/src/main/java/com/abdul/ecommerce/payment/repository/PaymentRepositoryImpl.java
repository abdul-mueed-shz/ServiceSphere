package com.abdul.ecommerce.payment.repository;

import com.abdul.ecommerce.payment.document.Payment;
import com.abdul.toolkit.utils.customer.dto.PaymentRequest;
import com.abdul.ecommerce.payment.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {
    private final PaymentMongoRepository paymentMongoRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public String createPayment(PaymentRequest paymentRequest) {
        Payment payment = paymentMongoRepository.save(paymentMapper.mapToPayment(paymentRequest));
        return payment.getId();
    }

}
