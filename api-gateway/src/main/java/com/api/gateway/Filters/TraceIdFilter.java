package com.api.gateway.Filters;


import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Order(2)
public class TraceIdFilter implements GlobalFilter{

    private final Tracer tracer;
    private static final String TRACE_ID_HEADER = "x-trace-id";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String traceId = tracer.currentTraceContext().context().traceId();
        exchange.getResponse().getHeaders().add(TRACE_ID_HEADER, traceId);
        return chain.filter(exchange);
    }
}
