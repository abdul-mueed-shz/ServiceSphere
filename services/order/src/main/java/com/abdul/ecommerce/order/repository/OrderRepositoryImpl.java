package com.abdul.ecommerce.order.repository;

import com.abdul.ecommerce.order.dto.OrderRequest;
import com.abdul.ecommerce.order.entity.Order;
import com.abdul.ecommerce.order.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository{
    private final OrderJpaRepository orderJpaRepository;
    private final OrderMapper orderMapper;

    public Integer save(OrderRequest orderRequest) {
        Order order = orderJpaRepository.save(orderMapper.mapToOrder(orderRequest));
        return order.getId();
    }
}
