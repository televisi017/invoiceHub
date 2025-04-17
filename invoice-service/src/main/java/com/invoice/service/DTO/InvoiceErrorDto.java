package com.invoice.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class InvoiceErrorDto {
    private String errorMessage;
    private List<String> errorDetails;
}
