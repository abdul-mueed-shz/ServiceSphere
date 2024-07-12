package com.abdul.toolkit.utils.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Validated
public class Address {

    private String street;
    private String houseNumber;
    private String city;
    private String state;
    private String zipCode;
}
