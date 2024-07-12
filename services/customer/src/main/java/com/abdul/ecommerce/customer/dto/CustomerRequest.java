package com.abdul.ecommerce.customer.dto;

import com.abdul.toolkit.utils.customer.entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        String id,
        @NotNull(message = "Firstname required")
        String firstName,
        @NotNull(message = "LastName required")
        String lastName,
        @NotNull(message = "Email required")
        @Email(message = "Customer email is not valid")
        String email,
        Address address
) {

}
