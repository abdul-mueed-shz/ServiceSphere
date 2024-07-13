package com.abdul.ecommerce.order.repository;

import com.abdul.ecommerce.order.dto.OrderRequest;

public interface OrderRepository {

    Integer save(OrderRequest orderRequest);

    Boolean orderExists(Integer orderId);
}
