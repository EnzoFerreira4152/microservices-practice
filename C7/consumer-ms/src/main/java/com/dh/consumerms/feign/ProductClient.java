package com.dh.consumerms.feign;

import com.dh.consumerms.configuration.LoadBalanceConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@FeignClient("product-service")
@Component
@LoadBalancerClient(name = "product-service",configuration = LoadBalanceConfiguration.class)
public interface ProductClient {

    @GetMapping("product/info")
    ArrayList<String> getProducts();
}
