package com.manumb.checkoutservice.service.impl;

import com.manumb.checkoutservice.model.dto.Product;
import com.manumb.checkoutservice.repository.FeignProductRepository;
import com.manumb.checkoutservice.service.IProductService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    private FeignProductRepository feignProductRepository;
    private static final Logger log = LoggerFactory.getLogger(ProductService.class);


    @Override
    @CircuitBreaker(name = "product", fallbackMethod="getProductFallbackMethod")
    @Retry(name="product")
    public Product getProduct(String id) {
        log.info("Intentando Obtener el producto con ID :" + id);
        return feignProductRepository.getProductById(id, true);
    }

    public Product getProductFallbackMethod(String id, CallNotPermittedException exception ) {
        log.error("Circuit breaker en estado Open");
        return new Product();
    }
}
