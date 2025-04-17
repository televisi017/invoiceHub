package com.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import reactor.core.publisher.Hooks;

@SpringBootApplication
@EnableReactiveMethodSecurity
public class ApiGatewayApplication {
	public static void main(String[] args) {
		Hooks.enableAutomaticContextPropagation();
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
}