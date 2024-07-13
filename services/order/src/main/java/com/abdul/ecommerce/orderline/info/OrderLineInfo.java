package com.abdul.ecommerce.orderline.info;

import com.abdul.ecommerce.order.info.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineInfo {
    private Integer id;
    private Integer productId;
    private String productName;
    private Double quantity;
}