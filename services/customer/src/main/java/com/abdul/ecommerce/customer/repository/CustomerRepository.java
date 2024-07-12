package com.abdul.ecommerce.customer.repository;

import com.abdul.toolkit.utils.customer.info.CustomerInfo;
import java.util.List;

public interface CustomerRepository {

    String save(CustomerInfo customerInfo);

    CustomerInfo findById(String id);

    void update(CustomerInfo customerInfo);

    List<CustomerInfo> findAll();

    Boolean existsById(String customerId);

    void deleteById(String customerId);
}
