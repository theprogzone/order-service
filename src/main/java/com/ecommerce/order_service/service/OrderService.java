package com.ecommerce.order_service.service;

import com.ecommerce.order_service.dto.OrderDTO;

public interface OrderService {

    void createOrder(OrderDTO orderDTO);
}
