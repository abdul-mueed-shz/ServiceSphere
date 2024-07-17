package com.abdul.ecommerce.notification.document;

import com.abdul.ecommerce.notification.dto.OrderConfirmation;
import com.abdul.ecommerce.notification.dto.PaymentConfirmation;
import com.abdul.toolkit.common.enums.NotificationType;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Notification {

    @Id
    private String id;

    @Enumerated
    private NotificationType type;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdOn;

    private OrderConfirmation orderConfirmation;
    private PaymentConfirmation paymentConfirmation;
}
