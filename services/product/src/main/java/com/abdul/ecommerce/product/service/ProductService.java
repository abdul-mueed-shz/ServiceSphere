package com.abdul.ecommerce.product.service;

import com.abdul.ecommerce.product.dto.ProductPurchaseRequest;
import com.abdul.ecommerce.product.dto.ProductRequest;
import com.abdul.ecommerce.product.info.ProductResponse;
import com.abdul.ecommerce.product.info.ProductPurchaseResponse;
import com.abdul.ecommerce.product.repository.ProductRepository;
import com.abdul.toolkit.common.exception.ApplicationException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Integer createProduct(ProductRequest productRequest) {
        return productRepository.createProduct(productRequest);
    }

    public void updateProduct(ProductRequest productRequest) {
        checkProductExists(productRequest.id());
        productRepository.updateProduct(productRequest);
    }

    public List<ProductResponse> getProducts() {
        return productRepository.getProducts();
    }

    public ProductResponse getProduct(Integer productId) {
        checkProductExists(productId);
        return productRepository.getProduct(productId);
    }

    public Boolean productExistsById(Integer productId) {
        return checkProductExists(productId);
    }

    public void deleteProduct(Integer productId) {
        checkProductExists(productId);
        productRepository.deleteProduct(productId);
    }

    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> productPurchaseRequest) {
        return Collections.emptyList();
    }

    private Boolean checkProductExists(Integer productId) {
        Boolean existsById = productRepository.productExistsById(productId);
        if (Objects.isNull(existsById)) {
            throw new ApplicationException("Product with ID " + productId + " does not exist");
        }
        return existsById;
    }
}
