package com.abdul.ecommerce.product.mapper;

import com.abdul.ecommerce.product.dto.ProductRequest;
import com.abdul.ecommerce.product.entity.Product;
import com.abdul.ecommerce.product.info.ProductResponse;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponse productToProductResponse(Product product);

    List<ProductResponse>
    productsToProductResponses(List<Product> products);

    Product productRequestToProduct(ProductRequest productRequest);

    List<Product> productResponsesToProduct(List<ProductResponse> productResponses);
}
