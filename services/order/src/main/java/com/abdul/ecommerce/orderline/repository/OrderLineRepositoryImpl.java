package com.abdul.ecommerce.orderline.repository;

import com.abdul.ecommerce.order.entity.Order;
import com.abdul.ecommerce.order.repository.OrderJpaRepository;
import com.abdul.ecommerce.orderline.dto.OrderLineRequest;
import com.abdul.ecommerce.orderline.entity.OrderLine;
import com.abdul.ecommerce.orderline.info.OrderLineResponse;
import com.abdul.ecommerce.orderline.mapper.OrderLineMapper;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderLineRepositoryImpl implements OrderLineRepostory{
    private final OrderLineJpaRepository orderLineJpaRepository;
    private final OrderJpaRepository orderJpaRepository;
    private final OrderLineMapper orderLineMapper;

    @Override
    public void saveAll(List<OrderLineRequest> orderLineRequestList) {
        orderLineJpaRepository.saveAll(orderLineMapper.mapToOrderLine(orderLineRequestList));
    }

    @Override
    public Integer save(OrderLineRequest orderLineRequest) {
        OrderLine orderLine = orderLineJpaRepository.save(orderLineMapper.mapToOrderLine(orderLineRequest));
        return orderLine.getId();
    }

    @Override
    public List<OrderLineResponse> getOrderLinesByOrderId(Integer orderId){
        Optional<Order> orderOptional = orderJpaRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            List<OrderLine> orderLine = orderLineJpaRepository.findOrderLineByOrder(orderOptional.get());
            return orderLineMapper.mapToOrderLineResponse(orderLine);
        }
        return Collections.emptyList();
    }
}
