package com.example.url_short.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.url_short.Service.ServicioDeNews;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("api/news")
@AllArgsConstructor
public class newsController {

    private final ServicioDeNews serviceDeNews;
    
  
    @GetMapping("/urls")
    public ResponseEntity<List<String>> urlsNews() {

        List<String> urls = serviceDeNews.url_news();

        return ResponseEntity.ok(urls);

    }

}
