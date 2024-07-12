package com.abdul.ecommerce.orderline.repository;

import com.abdul.ecommerce.orderline.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineJpaRepository extends JpaRepository<OrderLine, Long> {

}
