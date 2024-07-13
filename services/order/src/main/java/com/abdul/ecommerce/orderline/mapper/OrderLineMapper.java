package com.abdul.ecommerce.orderline.mapper;

import com.abdul.ecommerce.order.entity.Order;
import com.abdul.ecommerce.order.info.OrderResponse;
import com.abdul.ecommerce.orderline.dto.OrderLineRequest;
import com.abdul.ecommerce.orderline.entity.OrderLine;
import com.abdul.ecommerce.orderline.info.OrderLineInfo;
import com.abdul.ecommerce.orderline.info.OrderLineResponse;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderLineMapper {

    public List<OrderLine> mapToOrderLine(List<OrderLineRequest> orderLineRequestList) {
        List<OrderLine> orderLines = new ArrayList<>();
        for (OrderLineRequest orderLineRequest : orderLineRequestList) {
            orderLines.add(
                    OrderLine.builder()
                            .order(
                                    Order.builder()
                                            .id(orderLineRequest.getOrderId())
                                            .build()
                            )
                            .productId(orderLineRequest.getProductId())
                            .productName(orderLineRequest.getProductName())
                            .quantity(orderLineRequest.getQuantity())
                            .build()
            );
        }
        return orderLines;
    }

    public OrderLine mapToOrderLine(OrderLineRequest orderLineRequest) {
        return OrderLine.builder()
                .order(
                        Order.builder()
                                .id(orderLineRequest.getOrderId())
                                .build()
                )
                .productId(orderLineRequest.getProductId())
                .productName(orderLineRequest.getProductName())
                .quantity(orderLineRequest.getQuantity())
                .build();
    }

    public List<OrderLineResponse> mapToOrderLineResponse(List<OrderLine> orderLines) {
        List<OrderLineResponse> orderLineResponses = new ArrayList<>();
        for (OrderLine orderLine : orderLines) {
            orderLineResponses.add(
                    OrderLineResponse.builder()
                            .id(orderLine.getId())
                            .order(
                                    OrderResponse.builder()
                                            .orderId(orderLine.getOrder().getId())
                                            .paymentMethod(orderLine.getOrder().getPaymentMethod())
                                            .amount(orderLine.getOrder().getTotalAmount())
                                            .customerId(orderLine.getOrder().getCustomerId())
                                            .reference(orderLine.getOrder().getReference())
                                            .build()
                            )
                            .productId(orderLine.getProductId())
                            .productName(orderLine.getProductName())
                            .quantity(orderLine.getQuantity())
                            .build()
            );
        }
        return orderLineResponses;
    }

    public List<OrderLineInfo> mapToOrderLineInfo(List<OrderLine> orderLines) {
        List<OrderLineInfo> orderLineInfos = new ArrayList<>();
        for (OrderLine orderLine : orderLines) {
            orderLineInfos.add(
                    OrderLineInfo.builder()
                            .id(orderLine.getId())
                            .productId(orderLine.getProductId())
                            .productName(orderLine.getProductName())
                            .quantity(orderLine.getQuantity())
                            .build()
            );
        }
        return orderLineInfos;
    }
}
