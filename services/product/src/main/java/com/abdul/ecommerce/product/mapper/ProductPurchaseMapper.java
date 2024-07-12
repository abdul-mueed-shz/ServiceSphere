package com.abdul.ecommerce.product.mapper;

import com.abdul.toolkit.utils.product.info.ProductPurchaseResponse;
import com.abdul.ecommerce.product.info.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public class ProductPurchaseMapper {
    public ProductPurchaseResponse map(ProductResponse productResponse, Double quantity) {
        return new ProductPurchaseResponse(
                productResponse.getId(),
                productResponse.getName(),
                productResponse.getDescription(),
                productResponse.getPrice(),
                quantity
        );
    }
}
