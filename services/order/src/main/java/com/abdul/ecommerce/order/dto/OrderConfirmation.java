package com.abdul.ecommerce.order.dto;

import com.abdul.toolkit.common.enums.PaymentMethod;
import com.abdul.toolkit.utils.customer.info.CustomerInfo;
import com.abdul.toolkit.utils.product.info.ProductPurchaseResponse;
import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerInfo customerInfo,
        List<ProductPurchaseResponse> products
) {

}
