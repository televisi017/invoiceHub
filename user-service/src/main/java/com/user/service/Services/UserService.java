package com.user.service.Services;

import com.user.service.DTOs.InvoiceDto;
import com.user.service.DTOs.UserDto;
import com.user.service.Entities.User;
import com.user.service.Exceptions.UserNotFoundException;
import com.user.service.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final InvoiceService invoiceService;
    private final UserRepository userRepository;

    public List<UserDto> getUsersById(List<String> ids){
        return ids.stream().map((String id)->{
            User user = userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id, List.of("UserId")));
            List<InvoiceDto> invoices = invoiceService.callInvoiceServiceAndGetInvoiceByUser(id);
            return new UserDto(
                    user.getName(),
                    user.getAge(),
                    user.getGender(),
                    invoices
           );
        }).collect(Collectors.toList());
    }

    public UserDto getUserById(String id){
        User user = userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id, List.of("UserId")));
        List<InvoiceDto> invoices = invoiceService.callInvoiceServiceAndGetInvoiceByUser(id);
        return new UserDto(
                user.getName(),
                user.getAge(),
                user.getGender(),
                invoices
        );
    }
}
