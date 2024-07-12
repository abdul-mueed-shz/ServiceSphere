package com.abdul.toolkit.utils.product.service;

import com.abdul.toolkit.utils.product.dto.ProductPurchaseRequest;
import com.abdul.toolkit.utils.product.info.ProductPurchaseResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ProductRestTemplateService {
    @Value("${application.config.product-url}")
    private String PRODUCT_URL;

    private final RestTemplate restTemplate;

    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> productPurchaseRequests) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<List<ProductPurchaseRequest>> requestEntity = new HttpEntity<>(productPurchaseRequests, headers);

        ParameterizedTypeReference<List<ProductPurchaseResponse>> responseType =
                new ParameterizedTypeReference<>() {};

        ResponseEntity<List<ProductPurchaseResponse>> responseEntity = restTemplate.exchange(
                PRODUCT_URL + "/purchase",
                HttpMethod.POST,
                requestEntity,
                responseType
        );
        return responseEntity.getBody();
    }
}
