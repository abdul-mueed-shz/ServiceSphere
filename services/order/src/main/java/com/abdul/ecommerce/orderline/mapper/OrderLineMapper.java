package com.abdul.ecommerce.orderline.mapper;

import com.abdul.ecommerce.order.entity.Order;
import com.abdul.ecommerce.orderline.dto.OrderLineRequest;
import com.abdul.ecommerce.orderline.entity.OrderLine;
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
                            .quantity(orderLineRequest.getQuantity())
                            .build()
            );
        }
        return orderLines;
    }
}
