package com.abdul.toolkit.payment.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "customer-service",
        url = "${application.config.payment-url}"
)
public interface PaymentClient {

}
