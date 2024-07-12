package com.abdul.ecommerce.product.repository;

import com.abdul.ecommerce.product.dto.ProductRequest;
import com.abdul.ecommerce.product.info.ProductResponse;
import java.util.List;

public interface ProductRepository {

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(ProductRequest ProductRequest);

    List<ProductResponse> getProducts();

    ProductResponse getProduct(Integer productId);

    Boolean productExistsById(Integer productId);

    void deleteProduct(Integer productId);


    List<ProductResponse> findAllByIdInOrderById(List<Integer> products);

    void saveProducts(List<ProductResponse> storedProducts);
}
