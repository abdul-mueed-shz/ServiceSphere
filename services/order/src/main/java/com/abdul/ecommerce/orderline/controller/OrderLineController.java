package com.abdul.ecommerce.orderline.controller;

import com.abdul.ecommerce.orderline.dto.OrderLineRequest;
import com.abdul.ecommerce.orderline.info.OrderLineResponse;
import com.abdul.ecommerce.orderline.service.OrderLineService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order-lines")
@RequiredArgsConstructor
public class OrderLineController {
    private final OrderLineService orderLineService;

    @PostMapping
    public ResponseEntity<Integer> addOrderLine(@RequestBody @Valid OrderLineRequest orderLineRequest) {
        return ResponseEntity.ok(orderLineService.save(orderLineRequest));
    }

    @PostMapping("/save-all")
    public void addOrderLine(@RequestBody @Valid List<OrderLineRequest> orderLineRequestList) {
        orderLineService.saveAll(orderLineRequestList);

    }

    @GetMapping("/{orderId}")
    public ResponseEntity<List<OrderLineResponse>> getOrderLinesByOrderId(@PathVariable("orderId") Integer orderId) {
        return ResponseEntity.ok(orderLineService.getOrderLinesByOrderId(orderId));
    }

}
