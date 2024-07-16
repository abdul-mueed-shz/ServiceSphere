package com.abdul.toolkit.client;

import com.abdul.toolkit.utils.customer.dto.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "payment-client",
        url = "${application.config.payment-url}"
)
public interface PaymentClient {

    @PostMapping
    ResponseEntity<String> createPayment(@RequestBody PaymentRequest paymentRequest);
}
