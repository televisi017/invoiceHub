package com.api.gateway.Controllers;

import com.api.gateway.DTOs.ProductRequest;
import com.api.gateway.DTOs.RequestStatus;
import com.api.gateway.Services.KafkaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/async")
@RequiredArgsConstructor
@Slf4j
public class AsyncController {

    private final KafkaService kafkaService;

    @PostMapping("/products")
    public ResponseEntity<RequestStatus> sendProducts(@RequestBody ProductRequest productRequest){

        log.info("Product request received: {}", productRequest);

        try{

            kafkaService.sendProducts(productRequest);

        } catch (Exception e){
            log.info(e.getMessage());
            throw e;
        }

        return new ResponseEntity<>(new RequestStatus("Success"), HttpStatus.ACCEPTED);
    }

}
