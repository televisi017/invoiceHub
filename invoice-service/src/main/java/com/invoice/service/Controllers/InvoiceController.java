package com.invoice.service.Controllers;

import com.invoice.service.DTO.InvoiceDto;
import com.invoice.service.DTO.InvoiceRequest;
import com.invoice.service.Exceptions.InvoiceException;
import com.invoice.service.Services.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/invoices")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping("/by-users")
    public ResponseEntity<List<InvoiceDto>> getInvoiceByUsers(@RequestBody(required = false) InvoiceRequest invoiceRequest){
        if(invoiceRequest == null || invoiceRequest.userIds().isEmpty()) throw new InvoiceException(
                HttpStatus.BAD_REQUEST,
                "Please provide with the user ids",
                List.of("userId")
        );
        return new ResponseEntity<>(invoiceService.getInvoiceListForUsers(invoiceRequest.userIds()), HttpStatus.OK);
    }

    @PostMapping("/by-user/{userId}")
    public ResponseEntity<List<InvoiceDto>> getInvoiceByUser(@PathVariable String userId){
        if(userId == null || userId.isBlank()) throw new InvoiceException(
                HttpStatus.BAD_REQUEST,
                "Please provide with the user id",
                List.of("userId")
        );
        return new ResponseEntity<>(invoiceService.getInvoiceListForUser(userId), HttpStatus.OK);
    }
}
