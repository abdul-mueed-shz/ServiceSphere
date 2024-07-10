package com.abdul.ecommerce.product.info;

import java.math.BigDecimal;

public record ProductPurchaseResponse(
    Integer productId,
    String productName,
    String productDescription,
    BigDecimal productPrice,
    Double quantity
) {
}
