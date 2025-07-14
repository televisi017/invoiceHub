package com.product.service.DTOs;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class ProductDto {

    String name;
    String description;
    Double price;
    Integer stockQuantity;
}
