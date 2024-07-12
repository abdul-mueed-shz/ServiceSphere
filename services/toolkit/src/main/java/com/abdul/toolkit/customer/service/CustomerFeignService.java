package com.abdul.toolkit.customer.service;

import com.abdul.toolkit.client.CustomerClient;
import com.abdul.toolkit.customer.info.CustomerInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomerFeignService {
    private final CustomerClient customerClient;

    public CustomerInfo getCustomer(String customerId) {
        return customerClient.getCustomer(customerId).getBody();
    }
}
