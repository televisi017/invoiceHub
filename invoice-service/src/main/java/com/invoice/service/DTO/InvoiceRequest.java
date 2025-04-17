package com.invoice.service.DTO;
import jakarta.validation.constraints.NotNull;

import java.util.List;
public record InvoiceRequest(
        @NotNull
        List<String> userIds
){}
