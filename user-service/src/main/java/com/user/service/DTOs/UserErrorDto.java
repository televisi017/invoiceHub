package com.user.service.DTOs;

import lombok.*;

import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
public class UserErrorDto {
    private String errorMessage;
    private List<String> errorDetails;
}
