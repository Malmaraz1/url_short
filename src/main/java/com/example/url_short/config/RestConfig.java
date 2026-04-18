package com.example.url_short.config;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class RestConfig {
    
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // El builder de Spring Boot te permite configurar timeouts fácilmente
        return builder
                .connectTimeout(Duration.ofSeconds(5))
                .readTimeout(Duration.ofSeconds(5))
                .build();
    }
    
}
