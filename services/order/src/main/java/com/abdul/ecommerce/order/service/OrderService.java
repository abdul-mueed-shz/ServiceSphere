package com.abdul.ecommerce.order.service;

import com.abdul.ecommerce.order.dto.OrderConfirmation;
import com.abdul.ecommerce.order.dto.OrderRequest;
import com.abdul.ecommerce.order.entity.Order;
import com.abdul.ecommerce.order.info.OrderResponse;
import com.abdul.ecommerce.order.messaging.producer.OrderProducer;
import com.abdul.ecommerce.order.repository.OrderRepositoryImpl;
import com.abdul.ecommerce.orderline.dto.OrderLineRequest;
import com.abdul.ecommerce.orderline.service.OrderLineService;
import com.abdul.toolkit.common.exception.ApplicationException;
import com.abdul.toolkit.utils.customer.info.CustomerInfo;
import com.abdul.toolkit.utils.customer.service.CustomerFeignService;
import com.abdul.toolkit.utils.product.dto.ProductPurchaseRequest;
import com.abdul.toolkit.utils.product.info.ProductPurchaseResponse;
import com.abdul.toolkit.utils.product.service.ProductRestTemplateService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepositoryImpl orderRepository;
    private final CustomerFeignService customerFeignService;
    private final ProductRestTemplateService productRestTemplateService;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;

    public Integer createOrder(OrderRequest orderRequest) {
        /*
         * 1- Check customer
         * 2- Purchase the products -> product-msg
         * 3- Persist Order
         * 4- Persist Order Lines
         * 5- Start Payment Process TODO
         * 6- Send Order Confirmation -> notification-msg (kafka) TODO
         */
        CustomerInfo customerInfo = customerFeignService.getCustomer(orderRequest.customerId());
        List<ProductPurchaseResponse> productPurchaseResponses = productRestTemplateService
                .purchaseProducts(orderRequest.products());
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
        orderProducer.sendOderConfirmation(
                new OrderConfirmation(
                        orderRequest.reference(),
                        orderRequest.amount(),
                        orderRequest.paymentMethod(),
                        customerInfo,
                        productPurchaseResponses
                )
        );
        return orderId;
    }

    public List<OrderResponse> getOrders() {
        return orderRepository.getOrders();
    }

    public OrderResponse getOrder(Integer orderId) {
        Boolean orderExists = orderRepository.orderExists(orderId);
        if (Boolean.FALSE.equals(orderExists)) {
            throw new ApplicationException("Order with orderId %d does not exist".formatted(orderId));
        }
        return orderRepository.getOrder(orderId);
    }
}
