package com.abdul.ecommerce.order.info;

import com.abdul.ecommerce.orderline.info.OrderLineInfo;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class OrderDetailResponse extends OrderResponse{
    List<OrderLineInfo> orderLines;
}
