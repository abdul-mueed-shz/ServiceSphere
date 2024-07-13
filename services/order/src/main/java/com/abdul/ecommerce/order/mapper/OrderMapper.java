package com.abdul.ecommerce.order.mapper;

import com.abdul.ecommerce.order.dto.OrderRequest;
import com.abdul.ecommerce.order.entity.Order;
import com.abdul.ecommerce.order.info.OrderDetailResponse;
import com.abdul.ecommerce.order.info.OrderResponse;
import com.abdul.ecommerce.orderline.entity.OrderLine;
import com.abdul.ecommerce.orderline.info.OrderLineResponse;
import com.abdul.ecommerce.orderline.mapper.OrderLineMapper;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final OrderLineMapper orderLineMapper;

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

    public OrderDetailResponse mapToOrderResponse(Order order, List<OrderLine> orderLines) {
        return OrderDetailResponse.builder()
                .orderId(order.getId())
                .reference(order.getReference())
                .amount(order.getTotalAmount())
                .paymentMethod(order.getPaymentMethod())
                .customerId(order.getCustomerId())
                .orderLines(
                        orderLineMapper.mapToOrderLineInfo(orderLines)
                )
                .build();
    }
}
