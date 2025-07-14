package com.product.service.Exceptions;

import com.product.service.DTOs.ProductErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductErrorDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        return new ResponseEntity<>(new ProductErrorDto(productNotFoundException.getErrorMessage(), productNotFoundException.getErrorDetails()), HttpStatus.BAD_REQUEST);
    }

}
