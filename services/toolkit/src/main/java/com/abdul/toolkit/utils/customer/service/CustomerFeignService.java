package com.abdul.toolkit.utils.customer.service;

import com.abdul.toolkit.client.CustomerClient;
import com.abdul.toolkit.utils.customer.info.CustomerInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerFeignService {
    private final CustomerClient customerClient;

    public CustomerInfo getCustomer(String customerId) {
        return customerClient.getCustomer(customerId).getBody();
    }

    public Boolean customerExists(String customerId) {
        return customerClient.customerExists(customerId).getBody();
    }
}
