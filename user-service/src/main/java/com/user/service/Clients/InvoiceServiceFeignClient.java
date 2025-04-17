package com.user.service.Clients;

import com.user.service.DTOs.InvoiceDto;
import com.user.service.DTOs.InvoiceRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "invoice-service-feign-client", url = "${invoice.service.url}", path = "/v1/invoices")
public interface InvoiceServiceFeignClient {

    @PostMapping("/by-users")
    public ResponseEntity<List<InvoiceDto>> getInvoiceByUsers(@RequestBody(required = false) InvoiceRequest invoiceRequest);

    @PostMapping("/by-user/{userId}")
    public ResponseEntity<List<InvoiceDto>> getInvoiceByUser(@PathVariable String userId);
}
