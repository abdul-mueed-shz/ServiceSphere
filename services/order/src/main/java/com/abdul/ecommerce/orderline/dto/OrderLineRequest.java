package com.abdul.ecommerce.orderline.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderLineRequest {
    private Integer id;
    private Integer orderId;
    private Integer productId;
    private String productName;
    private Double quantity;
}
