package com.abdul.toolkit.client;

import com.abdul.toolkit.utils.customer.info.CustomerInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "customer-client",
        url = "${application.config.customer-url}"
)
public interface CustomerClient {
    @GetMapping("/{customerId}")
    ResponseEntity<CustomerInfo> getCustomer(@PathVariable("customerId") String customerId);
    @GetMapping("/exists/{customerId}")
    ResponseEntity<Boolean> customerExists(@PathVariable("customerId") String customerId);
}
