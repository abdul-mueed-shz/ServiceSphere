package com.abdul.ecommerce.order.service;

import com.abdul.ecommerce.order.dto.OrderRequest;
import com.abdul.ecommerce.order.mapper.OrderMapper;
import com.abdul.ecommerce.order.repository.OrderRepositoryImpl;
import com.abdul.ecommerce.orderline.dto.OrderLineRequest;
import com.abdul.ecommerce.orderline.service.OrderLineService;
import com.abdul.toolkit.common.exception.ApplicationException;
import com.abdul.toolkit.utils.customer.info.CustomerInfo;
import com.abdul.toolkit.utils.customer.service.CustomerFeignService;
import com.abdul.toolkit.utils.product.dto.ProductPurchaseRequest;
import com.abdul.toolkit.utils.product.service.ProductRestTemplateService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepositoryImpl orderRepository;
    private final CustomerFeignService customerFeignService;
    private final ProductRestTemplateService productRestTemplateService;
    private final OrderLineService orderLineService;

    public Integer createOrder(OrderRequest orderRequest) {
        /*
         * 1- Check customer
         * 2- Purchase the products -> product-msg
         * 3- Persist Order
         * 4- Persist Order Lines
         * 5- Start Payment Process TODO
         * 6- Send Order Confirmation -> notification-msg (kafka) TODO
         */
        Boolean customerExists = customerFeignService.customerExists(orderRequest.customerId());
        if (Boolean.FALSE.equals(customerExists)) {
            throw new ApplicationException("Customer with ID " + orderRequest.customerId() + " does not exist");
        }
        productRestTemplateService.purchaseProducts(orderRequest.products());
        Integer orderId = orderRepository.save(orderRequest);
        List<OrderLineRequest> orderLineRequestList = new ArrayList<>();
        for (ProductPurchaseRequest productPurchaseRequest: orderRequest.products()) {
            orderLineRequestList.add(
                    OrderLineRequest.builder()
                            .orderId(orderId)
                            .productId(productPurchaseRequest.productId())
                            .quantity(productPurchaseRequest.productQuantity())
                            .build()
            );
        }
        orderLineService.saveAll(orderLineRequestList);
        return orderId;
    }
}
