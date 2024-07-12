package com.abdul.ecommerce.orderline.service;

import com.abdul.ecommerce.orderline.dto.OrderLineRequest;
import com.abdul.ecommerce.orderline.repository.OrderLineRepositoryImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineService {
    private final OrderLineRepositoryImpl orderLineRepository;

    public void saveAll(List<OrderLineRequest> orderLineRequestList) {
        orderLineRepository.saveAll(orderLineRequestList);
    }
}
