package com.example.url_short.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.url_short.record.UrlShort;
import com.example.url_short.repository.UrlShortRepository;

import lombok.AllArgsConstructor;

@RestController
public class RedireccionController {

    private final UrlShortRepository urlShortRepository;

    public RedireccionController(UrlShortRepository urlShortRepository) {
        this.urlShortRepository = urlShortRepository;
    }

    @GetMapping("{shortId}")
    public ResponseEntity<Object> redireccion(@PathVariable String shortId) {

        return urlShortRepository.findById(shortId)
                .map(urlShort -> {
                    // 2. Si existe, redireccionamos a la URL larga
                    return ResponseEntity.status(HttpStatus.FOUND) // Código 302
                            .location(URI.create(urlShort.longUrl()))
                            .build();
                })
                // 3. Si no existe el ID, tiramos 404
                .orElse(ResponseEntity.notFound().build());
    }

}
