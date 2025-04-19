package com.api.gateway.DTOs;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
}
