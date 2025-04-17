package com.user.service.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class InvalidRequestException extends RuntimeException{
    private String errorMessage;
    private List<String> errorDetails;
}
