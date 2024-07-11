package com.abdul.toolkit.customer.service;

import com.abdul.toolkit.customer.client.CustomerClient;
import com.abdul.toolkit.customer.info.CustomerInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerClient customerClient;

    public ResponseEntity<CustomerInfo> getCustomer(String customerId) {
        return customerClient.getCustomer(customerId);
    }
}
