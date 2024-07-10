package com.abdul.ecommerce.product.dto;

import com.abdul.ecommerce.category.entity.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public record ProductRequest(
        Integer id,
        @NotNull(message = "Product name is required")
        String name,
        @NotNull(message = "Product description is required")
        String description,
        @NotNull(message = "Product price is required")
        BigDecimal price,
        @Positive(message = "Available quantity should be positive")
        Double availableQuantity,
        @NotNull(message = "Product category is required")
        Category category
) {

}
