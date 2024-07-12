package com.abdul.ecommerce.customer.service;

import com.abdul.toolkit.utils.customer.info.CustomerInfo;
import com.abdul.ecommerce.customer.repository.CustomerRepository;
import com.abdul.toolkit.common.exception.ApplicationException;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public String createCustomer(CustomerInfo customerInfo) {
        return customerRepository.save(customerInfo);
    }

    public void updateCustomer(CustomerInfo customerRequestInfo) {
        getCustomerOrElseThrowException(customerRequestInfo.getId());
        customerRepository.update(customerRequestInfo);
    }

    public List<CustomerInfo> getCustomers() {
        return customerRepository.findAll();
    }

    public CustomerInfo getCustomer(String customerId) {
        return getCustomerOrElseThrowException(customerId);
    }

    public Boolean customerExistsById(String customerId) {
        return customerRepository.existsById(customerId);
    }

    public void deleteCustomer(String customerId) {
        getCustomerOrElseThrowException(customerId);
        customerRepository.deleteById(customerId);
    }

    private CustomerInfo getCustomerOrElseThrowException(String customerId) {
        CustomerInfo customerInfo = customerRepository.findById(customerId);
        if (Objects.isNull(customerInfo)) {
            throw new ApplicationException("Customer with ID " + customerId + " does not exist");
        }
        return customerInfo;
    }

}
