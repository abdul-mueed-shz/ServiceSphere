package com.abdul.ecommerce.product.service;

import com.abdul.toolkit.utils.product.dto.ProductPurchaseRequest;
import com.abdul.ecommerce.product.dto.ProductRequest;
import com.abdul.ecommerce.product.info.ProductResponse;
import com.abdul.toolkit.utils.product.info.ProductPurchaseResponse;
import com.abdul.ecommerce.product.mapper.ProductPurchaseMapper;
import com.abdul.ecommerce.product.repository.ProductJpaRepository;
import com.abdul.ecommerce.product.repository.ProductRepository;
import com.abdul.toolkit.common.exception.ApplicationException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductJpaRepository productJpaRepository;
    private final ProductPurchaseMapper productPurchaseMapper;

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
        return productRepository.productExistsById(productId);
    }

    public void deleteProduct(Integer productId) {
        checkProductExists(productId);
        productRepository.deleteProduct(productId);
    }

    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> productPurchaseRequests) {
        List<Integer> products = productPurchaseRequests.stream().map(ProductPurchaseRequest::productId).toList();
        List<ProductResponse> storedProducts = productRepository.findAllByIdInOrderById(products);
        if (storedProducts.size() != products.size()) {
            throw new ApplicationException("One or more products were not found");
        }
        var storeProductsRequests = productPurchaseRequests
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                .toList();
        List<ProductPurchaseResponse> productPurchaseResponses = new ArrayList<>();
        for (int i = 0; i <storedProducts.size(); i++) {
            ProductPurchaseRequest productPurchaseRequest = storeProductsRequests.get(i);
            ProductResponse storedProductResponse = getProductResponse(storedProducts, i, productPurchaseRequest);
            productPurchaseResponses
                    .add(productPurchaseMapper.map(storedProductResponse, productPurchaseRequest.productQuantity()));
        }
        productRepository.saveProducts(storedProducts);
        return productPurchaseResponses;
    }

    private static ProductResponse getProductResponse(List<ProductResponse> storedProducts, int currentProductIndex,
            ProductPurchaseRequest productPurchaseRequest) {
        ProductResponse productResponse = storedProducts.get(currentProductIndex);
        if (productResponse.getAvailableQuantity() < productPurchaseRequest.productQuantity()) {
            throw new ApplicationException(
                    "Insufficient stock quantity for product %d".formatted(productPurchaseRequest.productId()));
        }
        Double newAvailableQuantity =
                productResponse.getAvailableQuantity() - productPurchaseRequest.productQuantity() ;
        productResponse.setAvailableQuantity(newAvailableQuantity);
        return productResponse;
    }

    private void checkProductExists(Integer productId) {
        Boolean existsById = productRepository.productExistsById(productId);
        if (Boolean.FALSE.equals(existsById)) {
            throw new ApplicationException("Product with ID " + productId + " does not exist");
        }
    }
}
