package com.product.service.DTOs;

import lombok.*;

import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
public class ProductErrorDto {
    private String errorMessage;
    private List<String> errorDetails;
}
