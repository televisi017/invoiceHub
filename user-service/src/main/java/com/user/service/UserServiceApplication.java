package com.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import co.elastic.apm.attach.ElasticApmAttacher;
@SpringBootApplication
@EnableFeignClients
public class UserServiceApplication {

	public static void main(String[] args) {
		ElasticApmAttacher.attach();
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
