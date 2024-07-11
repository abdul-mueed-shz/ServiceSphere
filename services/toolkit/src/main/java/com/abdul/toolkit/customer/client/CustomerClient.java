package com.abdul.toolkit.customer.client;

import com.abdul.toolkit.customer.info.CustomerInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "customer-service",
        url = "${application.config.customer-url}"
)
@Service
public interface CustomerClient {
    @GetMapping("/{customerId}")
    ResponseEntity<CustomerInfo> getCustomer(@PathVariable("customerId") String customerId);
}
