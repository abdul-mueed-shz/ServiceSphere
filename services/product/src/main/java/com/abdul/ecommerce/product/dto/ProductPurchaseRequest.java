package com.abdul.ecommerce.product.dto;

import jakarta.validation.constraints.NotNull;

public record ProductPurchaseRequest(
        @NotNull(message = "Product id is required")
        Integer productId,
        @NotNull(message = "Product quantity is required")
        Double productQuantity
) {

}
