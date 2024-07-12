package com.abdul.toolkit.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "payment-client",
        url = "${application.config.payment-url}"
)
public interface PaymentClient {

}
