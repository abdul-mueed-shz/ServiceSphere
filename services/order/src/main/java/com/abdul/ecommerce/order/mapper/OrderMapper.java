package com.abdul.ecommerce.order.mapper;

import com.abdul.ecommerce.order.dto.OrderRequest;
import com.abdul.ecommerce.order.entity.Order;
import com.abdul.ecommerce.order.info.OrderResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    public List<OrderResponse> mapToOrderResponseList(List<Order> orders) {
        List<OrderResponse> orderResponseList = new ArrayList<>();
        for (Order order : orders) {
            orderResponseList.add(
                    OrderResponse.builder()
                            .orderId(order.getId())
                            .amount(order.getTotalAmount())
                            .customerId(order.getCustomerId())
                            .paymentMethod(order.getPaymentMethod())
                            .reference(order.getReference())
                            .build()
            );
        }
        return orderResponseList;
    }

    public OrderResponse mapToOrderResponse(Order order) {
        return OrderResponse.builder()
                .orderId(order.getId())
                .amount(order.getTotalAmount())
                .customerId(order.getCustomerId())
                .paymentMethod(order.getPaymentMethod())
                .reference(order.getReference())
                .build();
    }
}
