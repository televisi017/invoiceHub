package com.user.service.DTOs;

import java.time.LocalDateTime;

public record InvoiceDto(
        String userId,
        String invoiceNumber,
        String productIds,
        LocalDateTime updatedTime
) {
}
