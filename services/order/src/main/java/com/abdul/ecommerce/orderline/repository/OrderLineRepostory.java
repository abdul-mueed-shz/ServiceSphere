package com.abdul.ecommerce.orderline.repository;

import com.abdul.ecommerce.orderline.dto.OrderLineRequest;
import com.abdul.ecommerce.orderline.info.OrderLineResponse;
import java.util.List;

public interface OrderLineRepostory {

    void saveAll(List<OrderLineRequest> orderLineRequestList);

    Integer save(OrderLineRequest orderLineRequest);

    List<OrderLineResponse> getOrderLinesByOrderId(Integer orderId);
}
