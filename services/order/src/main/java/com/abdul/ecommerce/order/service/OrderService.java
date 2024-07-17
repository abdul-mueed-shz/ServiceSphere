package com.abdul.ecommerce.order.service;

import com.abdul.ecommerce.order.dto.OrderConfirmation;
import com.abdul.ecommerce.order.dto.OrderRequest;
import com.abdul.ecommerce.order.info.OrderResponse;
import com.abdul.ecommerce.order.messaging.producer.OrderProducer;
import com.abdul.ecommerce.order.repository.OrderRepositoryImpl;
import com.abdul.ecommerce.orderline.dto.OrderLineRequest;
import com.abdul.ecommerce.orderline.service.OrderLineService;
import com.abdul.toolkit.common.exception.ApplicationException;
import com.abdul.toolkit.utils.customer.dto.PaymentRequest;
import com.abdul.toolkit.utils.customer.info.CustomerInfo;
import com.abdul.toolkit.utils.customer.mapper.CustomerMapper;
import com.abdul.toolkit.utils.customer.service.CustomerFeignService;
import com.abdul.toolkit.utils.payment.service.PaymentFeignService;
import com.abdul.toolkit.utils.product.dto.ProductPurchaseRequest;
import com.abdul.toolkit.utils.product.info.ProductPurchaseResponse;
import com.abdul.toolkit.utils.product.service.ProductRestTemplateService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepositoryImpl orderRepository;
    private final CustomerFeignService customerFeignService;
    private final ProductRestTemplateService productRestTemplateService;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentFeignService paymentFeignService;
    private final CustomerMapper customerMapper;

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
        Map<Integer, ProductPurchaseResponse> productPurchaseResponsesMap = productPurchaseResponses.stream()
                .collect(Collectors.toMap(ProductPurchaseResponse::productId, response -> response));
        Integer orderId = orderRepository.save(orderRequest);
        List<OrderLineRequest> orderLineRequestList = new ArrayList<>();
        for (ProductPurchaseRequest productPurchaseRequest : orderRequest.products()) {
            ProductPurchaseResponse productPurchaseResponse =
                    productPurchaseResponsesMap.get(productPurchaseRequest.productId());
            orderLineRequestList.add(
                    OrderLineRequest.builder()
                            .orderId(orderId)
                            .quantity(productPurchaseResponse.quantity())
                            .productId(productPurchaseResponse.productId())
                            .productName(productPurchaseResponse.productName())
                            .build()
            );
        }
        orderLineService.saveAll(orderLineRequestList);
        PaymentRequest paymentRequest = new PaymentRequest(
                null,
                orderId,
                orderRequest.amount(),
                orderRequest.paymentMethod(),
                customerMapper.mapCustomerInfoToCustomerDto(customerInfo)
        );
        String paymentId = paymentFeignService.createPayment(paymentRequest);
        log.info("Payment for order Id: {} created with payment Id: {}", orderId, paymentId);
        orderProducer.sendOrderConfirmation(
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
