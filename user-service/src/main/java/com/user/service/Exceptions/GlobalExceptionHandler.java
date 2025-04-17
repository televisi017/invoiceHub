package com.user.service.Exceptions;

import com.user.service.DTOs.UserErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<UserErrorDto> handleUserNotFound(UserNotFoundException userNotFoundException){
        return new ResponseEntity<>(new UserErrorDto(userNotFoundException.getErrorMessage(), userNotFoundException.getErrorDetails())
                , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<UserErrorDto>handleInvalidRequest(InvalidRequestException invalidRequestException){
        return new ResponseEntity<>(new UserErrorDto(invalidRequestException.getErrorMessage(), invalidRequestException.getErrorDetails())
                , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<UserErrorDto>handleUserException(UserException userException){
        return new ResponseEntity<>(new UserErrorDto(userException.getErrorMessage(), userException.getErrorDetails())
                , HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
