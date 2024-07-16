package com.abdul.toolkit.utils.customer.mapper;

import com.abdul.toolkit.utils.customer.dto.Customer;
import com.abdul.toolkit.utils.customer.info.CustomerInfo;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer mapCustomerInfoToCustomerDto(CustomerInfo customerInfo) {
        return new Customer(
                customerInfo.getId(),
                customerInfo.getFirstName(),
                customerInfo.getLastName(),
                customerInfo.getEmail()
        );
    }
}
