package com.invoice.service.Filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class RequestLoggingFilter implements Filter{

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        log.info("Incoming request : {} {}", httpServletRequest.getMethod(), httpServletRequest.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("Outgoing response: {}", httpServletResponse.getStatus());
    }
}
