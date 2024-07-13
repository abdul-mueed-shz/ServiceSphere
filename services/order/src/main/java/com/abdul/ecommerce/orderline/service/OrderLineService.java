package com.abdul.ecommerce.orderline.service;

import com.abdul.ecommerce.order.repository.OrderRepository;
import com.abdul.ecommerce.orderline.dto.OrderLineRequest;
import com.abdul.ecommerce.orderline.info.OrderLineResponse;
import com.abdul.ecommerce.orderline.repository.OrderLineRepositoryImpl;
import com.abdul.ecommerce.orderline.repository.OrderLineRepostory;
import com.abdul.toolkit.common.exception.ApplicationException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineService {
    private final OrderLineRepostory orderLineRepository;
    private final OrderRepository orderRepository;

    public void saveAll(List<OrderLineRequest> orderLineRequestList) {
        orderLineRepository.saveAll(orderLineRequestList);
    }

    public Integer save(OrderLineRequest orderLineRequest) {
        return orderLineRepository.save(orderLineRequest);
    }

    public List<OrderLineResponse> getOrderLinesByOrderId(Integer orderId) {
        Boolean orderExists = orderRepository.orderExists(orderId);
        if (Boolean.FALSE.equals(orderExists)) {
            throw new ApplicationException("Order with orderId %d does not exist".formatted(orderId));
        }
        return orderLineRepository.getOrderLinesByOrderId(orderId);
    }
}
