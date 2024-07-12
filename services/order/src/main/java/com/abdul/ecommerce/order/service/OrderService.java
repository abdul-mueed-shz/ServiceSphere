package com.abdul.ecommerce.order.service;

import com.abdul.ecommerce.order.dto.OrderRequest;
import com.abdul.ecommerce.order.repository.OrderRepositoryImpl;
import com.abdul.toolkit.customer.info.CustomerInfo;
import com.abdul.toolkit.customer.service.CustomerFeignService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepositoryImpl orderRepository;
    private final CustomerFeignService customerFeignService;

    public Integer createOrder(OrderRequest orderRequest) {
        /*
        * 1- Check customer
        * 2- Purchase the products -> product-msg
        * 3- Persist Order
        * 4- Persist Order Lines
        * 5- Start Payment Process
        * 6- Send Order Confirmation -> notification-msg (kafka)
        */
        CustomerInfo customerInfo = customerFeignService.getCustomer(orderRequest.customerId());

        return orderRequest.id();
    }
}
