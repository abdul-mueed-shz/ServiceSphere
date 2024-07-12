package com.abdul.ecommerce.order.info;

import com.abdul.toolkit.common.enums.PaymentMethod;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
    Integer orderId;
    String customerId;
    String reference;
    BigDecimal amount;
    PaymentMethod paymentMethod;
}
