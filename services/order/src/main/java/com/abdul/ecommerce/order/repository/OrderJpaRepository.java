package com.abdul.ecommerce.order.repository;

import com.abdul.ecommerce.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<Order, Integer> {

}
