package com.manumb.checkoutservice.repository;

import com.manumb.checkoutservice.configuration.LoadBalancerConfiguration;
import com.manumb.checkoutservice.model.dto.Product;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "products-eureka-client")
//Comentado por uso de round robin - @LoadBalancerClient(value = "products-eureka-client", configuration = LoadBalancerConfiguration.class)
public interface FeignProductRepository {
    @RequestMapping(method = RequestMethod.GET,value = "/products")
    Product getProductById(@RequestParam String id, @RequestParam Boolean throwError);
}
