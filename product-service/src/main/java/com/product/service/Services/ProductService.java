package com.product.service.Services;

import com.product.service.DTOs.ProductDto;
import com.product.service.Entities.Product;
import com.product.service.Exceptions.ProductNotFoundException;
import com.product.service.Repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> getProductsById(ArrayList<String> productIds){
        return productIds.stream().map((String id)->{
            Product product = productRepository.findById(id).orElseThrow(()->new ProductNotFoundException(id, List.of("user id")));
            return product;
        }).map((Product product)->{
            return new ProductDto(product.getName(), product.getDescription(), product.getPrice(), product.getStockQuantity());
        }).collect(Collectors.toList());
    }

    public ProductDto  getProductById(String id){
        Product product = productRepository.findById(id).orElseThrow(()->new ProductNotFoundException(id, List.of("userId")));
        return new ProductDto(product.getName(), product.getDescription(), product.getPrice(), product.getStockQuantity());
    }
}
