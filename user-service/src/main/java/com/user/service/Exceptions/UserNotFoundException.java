package com.user.service.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserNotFoundException extends RuntimeException{

    private String userId;
    private String errorMessage;
    private List<String> errorDetails;

    public UserNotFoundException(String userId, List<String> errorDetails){
        this.userId = userId;
        this.errorMessage = "User with id: "+userId+" not found.";
        this.errorDetails = errorDetails;
    }
}
