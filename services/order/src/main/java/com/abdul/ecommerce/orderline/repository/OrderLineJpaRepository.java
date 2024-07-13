package com.abdul.ecommerce.orderline.repository;

import com.abdul.ecommerce.order.entity.Order;
import com.abdul.ecommerce.orderline.entity.OrderLine;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineJpaRepository extends JpaRepository<OrderLine, Long> {
    List<OrderLine> findOrderLineByOrder(Order order);
}
