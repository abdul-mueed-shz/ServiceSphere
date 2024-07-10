package com.abdul.ecommerce.product.mapper;

import com.abdul.ecommerce.product.dto.ProductPurchaseRequest;
import com.abdul.ecommerce.product.dto.ProductRequest;
import com.abdul.ecommerce.product.entity.Product;
import com.abdul.ecommerce.product.info.ProductResponse;
import com.abdul.ecommerce.product.info.ProductPurchaseResponse;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDtoMapper {

    ProductResponse productToProductResponse(Product product);

    List<ProductResponse>
    productsToProductPurchaseResponse(List<Product> products);

    Product productRequestToProduct(ProductRequest productRequest);
}
