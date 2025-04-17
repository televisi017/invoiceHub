package com.user.service.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

@Configuration
@EnableRetry
public class RetryConfig {

    @Bean
    public RetryTemplate retryTemplate(){

        RetryTemplate retryTemplate = new RetryTemplate();

//        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
//        fixedBackOffPolicy.setBackOffPeriod(3000L);

        SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy();
        simpleRetryPolicy.setMaxAttempts(4);

        ExponentialBackOffPolicy exponentialBackOffPolicy = new ExponentialBackOffPolicy();
        exponentialBackOffPolicy.setInitialInterval(2000L);
        exponentialBackOffPolicy.setMultiplier(2);
        exponentialBackOffPolicy.setMaxInterval(10000L);


        retryTemplate.setBackOffPolicy(exponentialBackOffPolicy);
        retryTemplate.setRetryPolicy(simpleRetryPolicy);

        return retryTemplate;
    }
}
