package com.abdul.ecommerce.order.repository;

import com.abdul.ecommerce.order.dto.OrderRequest;
import com.abdul.ecommerce.order.entity.Order;
import com.abdul.ecommerce.order.info.OrderResponse;
import com.abdul.ecommerce.order.mapper.OrderMapper;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderMapper orderMapper;

    public Integer save(OrderRequest orderRequest) {
        Order order = orderJpaRepository.save(orderMapper.mapToOrder(orderRequest));
        return order.getId();
    }

    public List<OrderResponse> getOrders() {
        return orderMapper.mapToOrderResponseList(orderJpaRepository.findAll());
    }

    public OrderResponse getOrder(Integer orderId) {
        Optional<Order> order = orderJpaRepository.findById(orderId);
        return order.map(orderMapper::mapToOrderResponse).orElse(null);
    }
}
