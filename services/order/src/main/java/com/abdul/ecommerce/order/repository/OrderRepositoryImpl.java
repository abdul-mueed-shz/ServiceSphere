package com.abdul.ecommerce.order.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository{
    private final OrderJpaRepository orderJpaRepository;
}
