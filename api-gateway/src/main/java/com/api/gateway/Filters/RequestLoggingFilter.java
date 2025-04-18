package com.api.gateway.Filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@Order(1)
public class RequestLoggingFilter implements GlobalFilter{

    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain){

        log.info("Incoming request : {} {}", exchange.getRequest().getMethod(), exchange.getRequest().getURI());
        log.info("Outgoing response: {}", exchange.getResponse().getStatusCode());
        return chain.filter(exchange);
    }
}
