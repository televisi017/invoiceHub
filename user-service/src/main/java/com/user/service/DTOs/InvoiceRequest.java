package com.user.service.DTOs;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record InvoiceRequest(
        @NotNull
        List<String> userIds
){}
