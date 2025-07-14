package com.product.service.Controllers;

import com.product.service.DTOs.ProductDto;
import com.product.service.DTOs.ProductRequest;
import com.product.service.Services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    ResponseEntity<List<ProductDto>> productsByIds(ProductRequest productRequest) throws Exception{
        return new ResponseEntity<>(productService.getProductsById(productRequest.getProductIds()), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    ResponseEntity<ProductDto> productById(@PathVariable String id){
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }
}
