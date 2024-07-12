package com.abdul.ecommerce.customer.mapper;

import com.abdul.ecommerce.customer.dto.CustomerRequest;
import com.abdul.toolkit.utils.customer.info.CustomerInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerDtoMapper {

    CustomerInfo customerRequestToCustomerInfo(CustomerRequest customerRequest);
}
