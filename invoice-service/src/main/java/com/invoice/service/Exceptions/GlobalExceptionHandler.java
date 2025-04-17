package com.invoice.service.Exceptions;

import com.invoice.service.DTO.InvoiceErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvoiceException.class)
    public ResponseEntity<InvoiceErrorDto> invoiceErrorHandler(InvoiceException invoiceException){
        return new ResponseEntity<>(new InvoiceErrorDto(
                invoiceException.getErrorMessage(),
                invoiceException.getErrorDetails()
        ), invoiceException.getHttpStatus());
    }
}
