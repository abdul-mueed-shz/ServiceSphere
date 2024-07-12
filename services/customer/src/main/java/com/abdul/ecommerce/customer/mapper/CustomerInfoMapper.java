package com.abdul.ecommerce.customer.mapper;

import com.abdul.ecommerce.customer.document.Customer;
import com.abdul.toolkit.utils.customer.info.CustomerInfo;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CustomerInfoMapper {

    Customer customerInfoToCustomer(CustomerInfo customerRequest);

    CustomerInfo customerToCustomerInfo(Customer customer);

    void updateCustomerFromCustomerInfo(CustomerInfo customerInfo, @MappingTarget Customer customer);

    List<CustomerInfo> customersToCustomerInfos(List<Customer> customers);
}
