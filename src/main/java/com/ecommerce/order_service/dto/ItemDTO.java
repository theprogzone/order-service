package com.ecommerce.order_service.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemDTO {

    private Long productId;

    private String skuCode;

    private BigDecimal price;

    private Integer quantity;
}
