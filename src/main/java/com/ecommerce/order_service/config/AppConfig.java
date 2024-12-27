package com.ecommerce.order_service.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    //InventoryDTO inventoryDTO = webClientBuilder.build().get().uri("http://inventory-service/v1/api/inventory/"+product.getSkuCode()).retrieve().bodyToMono(InventoryDTO.class).block();

    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

}
