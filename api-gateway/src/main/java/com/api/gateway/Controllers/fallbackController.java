package com.api.gateway.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class fallbackController {

    @RequestMapping("/fallback")
    public ResponseEntity<String> fallback(){
        return new ResponseEntity<>("Service currently unavailable, try again in sometime.", HttpStatus.SERVICE_UNAVAILABLE);
    }
}
