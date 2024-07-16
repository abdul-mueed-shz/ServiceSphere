package com.abdul.toolkit.utils.customer.dto;

import com.abdul.toolkit.common.enums.PaymentMethod;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record PaymentRequest(
        String id,
        @NotNull(message = "Order id is required")
        Integer orderId,
        @NotNull(message = "Amount is required")
        BigDecimal amount,
        @NotNull(message = "Payment method is required")
        PaymentMethod paymentMethod,

        Customer customer
) {

}
