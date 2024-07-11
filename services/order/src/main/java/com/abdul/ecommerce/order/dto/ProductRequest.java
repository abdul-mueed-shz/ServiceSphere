package com.abdul.ecommerce.order.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequest(
        @NotNull(message = "Product Id is required")
        Integer productId,
        @Positive(message = "Product quantity is required")
        Double quantity
) {

}
