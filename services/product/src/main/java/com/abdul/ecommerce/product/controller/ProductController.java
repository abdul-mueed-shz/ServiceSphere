package com.abdul.ecommerce.product.controller;

import com.abdul.toolkit.utils.product.dto.ProductPurchaseRequest;
import com.abdul.ecommerce.product.dto.ProductRequest;
import com.abdul.ecommerce.product.info.ProductResponse;
import com.abdul.toolkit.utils.product.info.ProductPurchaseResponse;
import com.abdul.ecommerce.product.mapper.ProductMapper;
import com.abdul.ecommerce.product.service.ProductService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<Integer> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        return ResponseEntity.ok(productService
                .createProduct(productRequest));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>>
                         purchaseProduct(@RequestBody @Valid List<ProductPurchaseRequest> productPurchaseRequest) {
        return ResponseEntity.ok(productService
                .purchaseProducts(productPurchaseRequest));
    }

    @PutMapping
    public ResponseEntity<Void> updateProduct(@RequestBody @Valid ProductRequest productRequest) {
        productService.updateProduct(productRequest);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("productId") Integer productId) {
        return ResponseEntity.ok(productService.getProduct(productId));
    }

    @GetMapping("/exists/{productId}")
    public ResponseEntity<Boolean> productExistsById(@PathVariable("productId") Integer productId) {
        return ResponseEntity.ok(productService.productExistsById(productId));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Integer productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }
}
