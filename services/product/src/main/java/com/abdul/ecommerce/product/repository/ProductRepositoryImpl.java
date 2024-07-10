package com.abdul.ecommerce.product.repository;

import com.abdul.ecommerce.product.dto.ProductRequest;
import com.abdul.ecommerce.product.entity.Product;
import com.abdul.ecommerce.product.info.ProductPurchaseResponse;
import com.abdul.ecommerce.product.info.ProductResponse;
import com.abdul.ecommerce.product.mapper.ProductDtoMapper;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;
    private final ProductDtoMapper productDtoMapper;

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        Product product = productJpaRepository.save(productDtoMapper.productRequestToProduct(productRequest));
        return product.getId();
    }

    @Override
    public void updateProduct(ProductRequest productRequest) {
        productJpaRepository.save(productDtoMapper.productRequestToProduct(productRequest));
    }

    @Override
    public List<ProductResponse> getProducts() {
        List<Product>products = productJpaRepository.findAll();
        return productDtoMapper.productsToProductPurchaseResponse(products);
    }

    @Override
    public ProductResponse getProduct(Integer productId) {
        Optional<Product> productOptional = productJpaRepository.findById(productId);
        return productOptional.map(productDtoMapper::productToProductResponse).orElse(null);
    }

    @Override
    public Boolean productExistsById(Integer productId) {
        return productJpaRepository.existsById(productId);
    }

    @Override
    public void deleteProduct(Integer productId) {
        productJpaRepository.deleteById(productId);
    }

    @Override
    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseResponse> productPurchaseResponses) {
        return null;
    }
}
