package com.invoice.service.Services;

import com.invoice.service.DTO.InvoiceDto;
import com.invoice.service.Entities.Invoice;
import com.invoice.service.Repositories.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    private InvoiceDto invoiceToDto(Invoice invoice){
        return new InvoiceDto(
                invoice.getUserId(),
                invoice.getInvoiceNumber(),
                invoice.getProductIds(),
                invoice.getUpdatedTime()
        );
    }

    public List<InvoiceDto> getInvoiceListForUsers(List<String> userIds){
        return userIds.stream()
                .map((String user)->{
                    return invoiceRepository.findAllByUserId(user)
                            .stream()
                            .map((Invoice invoice)->invoiceToDto(invoice))
                            .collect(Collectors.toList());
                })
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public List<InvoiceDto> getInvoiceListForUser(String userId){
        return invoiceRepository.findAllByUserId(userId).stream()
                .map(this::invoiceToDto)
                .collect(Collectors.toList());
    }
}
