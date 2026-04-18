package com.example.url_short.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.url_short.record.NewReponse;
@Component
public class NewsClient {

    private final RestTemplate restTemplate;

    @Value("${api.news.url}")
    private String baseUrl;

    public NewsClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public NewReponse news() {

        NewReponse newReponse = restTemplate.getForObject(baseUrl, NewReponse.class);
        if (newReponse == null || newReponse.new_results() == null) {
            new RuntimeException("no se encontro api news");
        }

        return newReponse;

    }

}
