package com.abdul.ecommerce.customer.info;

import com.abdul.toolkit.customer.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerInfo {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
}
