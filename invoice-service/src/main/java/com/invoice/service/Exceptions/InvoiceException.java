package com.invoice.service.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
public class InvoiceException extends RuntimeException{

    private HttpStatus httpStatus;
    private String errorMessage;
    private List<String> errorDetails;

    public InvoiceException(HttpStatus httpStatus, String errorMessage, List<String> errorDetails){
        super(errorMessage);
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
        this.errorDetails = errorDetails;
    }
}
