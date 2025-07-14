package com.product.service.DTOs;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ProductRequest {
    ArrayList<String> productIds;
}
