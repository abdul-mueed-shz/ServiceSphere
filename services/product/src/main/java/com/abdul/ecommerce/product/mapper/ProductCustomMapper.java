package com.abdul.ecommerce.product.mapper;

import com.abdul.ecommerce.category.info.CategoryResponse;
import com.abdul.ecommerce.product.entity.Product;
import com.abdul.ecommerce.product.info.ProductResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductCustomMapper {

    public ProductResponse productToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .availableQuantity(product.getAvailableQuantity())
                .category(CategoryResponse.builder()
                        .id(product.getCategory().getId())
                        .name(product.getCategory().getName())
                        .description(product.getCategory().getDescription())
                        .build())
                .build();
    }

    public List<ProductResponse> productsToProductResponses(List<Product> products) {
        List<ProductResponse> productResponses = new ArrayList<>();
        products.forEach(product -> productResponses.add(
                ProductResponse.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .description(product.getDescription())
                        .availableQuantity(product.getAvailableQuantity())
                        .category(
                                CategoryResponse.builder()
                                        .id(product.getCategory().getId())
                                        .name(product.getCategory().getName())
                                        .description(product.getCategory().getDescription())
                                        .build())
                        .build()));
        return productResponses;
    }
}
