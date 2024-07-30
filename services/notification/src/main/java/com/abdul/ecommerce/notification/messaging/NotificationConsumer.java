package com.abdul.ecommerce.notification.messaging;

import com.abdul.ecommerce.email.service.EmailService;
import com.abdul.ecommerce.notification.document.Notification;
import com.abdul.ecommerce.notification.dto.OrderConfirmation;
import com.abdul.ecommerce.notification.dto.PaymentConfirmation;
import com.abdul.ecommerce.notification.repository.NotificationRepository;
import com.abdul.toolkit.common.enums.NotificationType;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationConsumer {

    private final NotificationRepository notificationRepository;
    private final EmailService emailService;

    @KafkaListener(topics = "payments", groupId = "paymentGroup",
            containerFactory = "paymentKafkaListenerContainerFactory")
    public void consumePaymentConfirmationNotification(PaymentConfirmation paymentConfirmation)
            throws MessagingException {
        log.info("Consuming kafka produced message for topic payments: {}", paymentConfirmation);
        notificationRepository.save(
                Notification.builder()
                        .type(NotificationType.PAYMENT_CONFIRMATION)
                        .paymentConfirmation(paymentConfirmation)
                        .build()
        );
        String customerName =
                paymentConfirmation.getCustomerFirstName() + " " + paymentConfirmation.getCustomerLastName();
        emailService.sendPaymentConfirmationEmail(
                paymentConfirmation.getCustomerEmail(),
                customerName,
                paymentConfirmation.getOrderId(),
                paymentConfirmation.getAmount()
        );
    }

    @KafkaListener(topics = "orders", groupId = "orderGroup",
            containerFactory = "orderKafkaListenerContainerFactory")
    public void consumeOrderConfirmationNotification(OrderConfirmation orderConfirmation) throws MessagingException {
        log.info("Consuming kafka produced message for orders: {}", orderConfirmation);
        notificationRepository.save(
                Notification.builder()
                        .type(NotificationType.ORDER_CONFIRMATION)
                        .orderConfirmation(orderConfirmation)
                        .build()
        );
        String customerName =
                orderConfirmation.customerInfo().getFirstName() + " " + orderConfirmation.customerInfo().getLastName();
        emailService.sendOrderConfirmationEmail(
                orderConfirmation.customerInfo().getEmail(),
                customerName,
                orderConfirmation.orderReference(),
                orderConfirmation.totalAmount(),
                orderConfirmation.products()
        );
    }
}
