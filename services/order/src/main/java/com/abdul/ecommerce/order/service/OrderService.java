package com.abdul.ecommerce.order.service;

import com.abdul.ecommerce.order.dto.OrderRequest;
import com.abdul.ecommerce.order.repository.OrderRepositoryImpl;
import com.abdul.toolkit.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepositoryImpl orderRepository;
    private final CustomerService customerService;

    public Integer createOrder(OrderRequest orderRequest) {
        /*
        * 1- Check customer
        * 2- Purchase the products -> product-msg
        * 3- Persist Order
        * 4- Persist Order Lines
        * 5- Start Payment Process
        * 6- Send Order Confirmation -> notification-msg (kafka)
        */
        return orderRequest.id();
    }
}
