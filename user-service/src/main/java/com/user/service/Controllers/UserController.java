package com.user.service.Controllers;

import com.user.service.DTOs.InvoiceDto;
import com.user.service.DTOs.UserDto;
import com.user.service.DTOs.UserRequestDto;
import com.user.service.Exceptions.InvalidRequestException;
import com.user.service.Services.InvoiceService;
import com.user.service.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/all")
    public ResponseEntity<List<UserDto>> getUsers(@RequestBody(required = false) UserRequestDto request){
        if(request == null || request.getUserIds().isEmpty()){
            throw new InvalidRequestException("Please provide with the user ids.", List.of("UserIds"));
        }
        return new ResponseEntity<>(userService.getUsersById(request.getUserIds()), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable String userId){
        if(userId == null || userId.isEmpty()){
            throw new InvalidRequestException("Please provide with the user id.", List.of("UserId"));
        }
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }
}
