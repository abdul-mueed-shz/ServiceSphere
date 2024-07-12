package com.abdul.ecommerce.orderline.repository;

import com.abdul.ecommerce.orderline.dto.OrderLineRequest;
import com.abdul.ecommerce.orderline.mapper.OrderLineMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderLineRepositoryImpl implements OrderLineRepostory{
    private final OrderLineJpaRepository orderLineJpaRepository;
    private final OrderLineMapper orderLineMapper;

    public void saveAll(List<OrderLineRequest> orderLineRequestList) {
        orderLineJpaRepository.saveAll(orderLineMapper.mapToOrderLine(orderLineRequestList));
    }
}
