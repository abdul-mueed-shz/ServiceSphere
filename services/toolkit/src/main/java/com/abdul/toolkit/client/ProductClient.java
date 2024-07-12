package com.abdul.toolkit.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "product-client",
        url = "${application.config.product-url}"
)
public interface ProductClient {

}
