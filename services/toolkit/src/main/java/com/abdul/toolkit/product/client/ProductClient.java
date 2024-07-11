package com.abdul.toolkit.product.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "customer-service",
        url = "${application.config.product-url}"
)
public interface ProductClient {

}
