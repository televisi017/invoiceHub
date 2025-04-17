package com.user.service.DTOs;

import lombok.*;

import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
public class UserRequestDto {
    private List<String> userIds;
}
