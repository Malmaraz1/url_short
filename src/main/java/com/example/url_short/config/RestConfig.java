package com.example.url_short.config;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
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
    
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        // Usamos String para las llaves
        template.setKeySerializer(new StringRedisSerializer());
        
        // Usamos JSON para los valores (así los ves claritos en Redis Insight)
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        
        return template;
    }
}
