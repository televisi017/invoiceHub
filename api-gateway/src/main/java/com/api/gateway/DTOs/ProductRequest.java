package com.api.gateway.DTOs;


import lombok.Data;

import java.util.List;

@Data
public class ProductRequest {
    private List<ProductDto> productDtoList;
}
