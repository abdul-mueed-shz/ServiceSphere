package com.abdul.ecommerce.notification.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


enum PaymentMethod {
    PAYPAL, CREDIT_CARD, DEBIT_CARD
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentConfirmation {

    @JsonProperty("orderId")
    private Integer orderId;

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("paymentMethod")
    private String paymentMethod;

    @JsonProperty("customerFirstName")
    private String customerFirstName;

    @JsonProperty("customerLastName")
    private String customerLastName;

    @JsonProperty("customerEmail")
    private String customerEmail;

    @JsonProperty("customerId")
    private String customerId;
}

