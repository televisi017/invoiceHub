package com.product.service.Exceptions;

import lombok.Getter;

import java.util.List;

@Getter
public class ProductNotFoundException extends RuntimeException {
  private String productId;
  private String errorMessage;
  private List<String> errorDetails;

  public ProductNotFoundException(String productId, List<String> errorDetails){
    this.productId = productId;
    this.errorMessage = "User with id: "+productId+" not found.";
    this.errorDetails = errorDetails;
  }
}
