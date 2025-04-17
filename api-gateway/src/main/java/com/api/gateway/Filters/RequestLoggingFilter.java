package com.api.gateway.Filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class RequestLoggingFilter {

    @Bean
    public GlobalFilter logRequestFilter(){

        return (exchange, chain) -> {

            log.info("Incoming request : {} {}", exchange.getRequest().getMethod(), exchange.getRequest().getURI());

            return chain.filter(exchange).then(Mono.fromRunnable(()->
                    log.info("Outgoing response: {}", exchange.getResponse().getStatusCode())
            ));
        };
    }
}
