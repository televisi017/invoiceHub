package com.user.service.DTOs;

import lombok.*;
import org.hibernate.id.IntegralDataTypeHolder;

import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private String name;
    private Integer age;
    private Character gender;
    private List<InvoiceDto> invoiceDtoList;
}
