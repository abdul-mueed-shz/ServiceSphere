package com.abdul.ecommerce.payment.messaging;

import com.abdul.ecommerce.payment.dto.PaymentConfirmation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentProducer {
    private final KafkaTemplate<String, PaymentConfirmation> kafkaTemplate;

    public void sendPaymentConfirmation(PaymentConfirmation paymentConfirmation) {
        log.info("Sending payment confirmation: {}", paymentConfirmation);
        Message<PaymentConfirmation> message = MessageBuilder
                .withPayload(paymentConfirmation)
                .setHeader(KafkaHeaders.TOPIC, "payments")
                .build();
        kafkaTemplate.send(message);
    }
}
