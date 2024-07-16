package com.abdul.toolkit.utils.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Customer(
        @NotNull(message = "Customer Id is required")
        String id,
        @NotNull(message = "Customer's first name is required")
        String firstName,
        @NotNull(message = "Customer's last name is required")
        String lastName,
        @NotNull(message = "Customer's email is required")
        @Email(message = "A valid email is required")
        String email
) {

}
