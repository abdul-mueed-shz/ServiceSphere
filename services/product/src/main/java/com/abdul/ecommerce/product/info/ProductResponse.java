package com.abdul.ecommerce.product.info;

import com.abdul.ecommerce.category.entity.Category;
import com.abdul.ecommerce.category.info.CategoryResponse;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductResponse {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Double availableQuantity;
    private CategoryResponse category;
}
