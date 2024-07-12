package com.abdul.ecommerce.order.mapper;

import com.abdul.ecommerce.order.dto.OrderRequest;
import com.abdul.ecommerce.order.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order mapToOrder(OrderRequest orderRequest) {
        return Order.builder()
                .id(orderRequest.id())
                .customerId(orderRequest.customerId())
                .reference(orderRequest.reference())
                .totalAmount(orderRequest.amount())
                .paymentMethod(orderRequest.paymentMethod())
                .build();
    }
}
