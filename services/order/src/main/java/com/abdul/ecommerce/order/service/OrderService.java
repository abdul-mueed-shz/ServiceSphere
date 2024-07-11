package com.abdul.ecommerce.order.service;

import com.abdul.ecommerce.order.dto.OrderRequest;
import com.abdul.ecommerce.order.repository.OrderRepository;
import com.abdul.ecommerce.order.repository.OrderRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepositoryImpl orderRepository;

    public Integer createOrder(OrderRequest orderRequest) {
        return 1;
    }
}
