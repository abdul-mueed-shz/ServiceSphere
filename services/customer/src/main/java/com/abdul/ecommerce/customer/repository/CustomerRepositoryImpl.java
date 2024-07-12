package com.abdul.ecommerce.customer.repository;

import com.abdul.ecommerce.customer.document.Customer;
import com.abdul.toolkit.utils.customer.info.CustomerInfo;
import com.abdul.ecommerce.customer.mapper.CustomerInfoMapper;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerInfoMapper customerInfoMapper;
    private final CustomerMongoRepository customerMongoRepository;

    @Override
    public String save(CustomerInfo customerInfo) {
        var customer = customerMongoRepository.save(customerInfoMapper.customerInfoToCustomer(customerInfo));
        return customer.getId();
    }

    @Override
    public CustomerInfo findById(String id) {
        Optional<Customer> customer = customerMongoRepository.findById(id);
        return customer.map(customerInfoMapper::customerToCustomerInfo).orElse(null);
    }

    @Override
    public void update(CustomerInfo customerRequestInfo) {
        Optional<Customer> customerOptional = customerMongoRepository.findById(customerRequestInfo.getId());
        customerOptional
                .ifPresent(customer -> {
                    customerInfoMapper.updateCustomerFromCustomerInfo(customerRequestInfo, customer);
                    customerMongoRepository.save(customer);
                });
    }

    @Override
    public List<CustomerInfo> findAll() {
        return customerInfoMapper.customersToCustomerInfos(customerMongoRepository.findAll());
    }

    @Override
    public Boolean existsById(String customerId) {
        return customerMongoRepository.existsById(customerId);
    }

    @Override
    public void deleteById(String customerId) {
        customerMongoRepository.deleteById(customerId);
    }
}
