package com.abdul.ecommerce.product.info;

import com.abdul.ecommerce.category.entity.Category;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponse {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Double availableQuantity;
    private Category category;
}
