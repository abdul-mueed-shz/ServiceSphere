package com.abdul.ecommerce.customer.dto;

import com.abdul.ecommerce.customer.document.Address;
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
