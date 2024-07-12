package com.abdul.ecommerce.order.dto;

import com.abdul.toolkit.common.enums.PaymentMethod;
import com.abdul.toolkit.utils.product.dto.ProductPurchaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(
        Integer id,
        String reference,

        @Positive(message = "Order amount should be positive")
        BigDecimal amount,

        @NotNull(message = "Payment method is required")
        PaymentMethod paymentMethod,

        @NotNull(message = "Customer Id is required")
        @NotEmpty(message = "Customer Id is required")
        @NotBlank(message = "Customer Id is required")
        String customerId,

        @NotEmpty(message = "At least one product is required for purchase")
        List<ProductPurchaseRequest> products

) {

}
