package com.example.url_short.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.apache.tomcat.util.digester.ServiceBindingPropertySource;
import org.springframework.stereotype.Service;

import com.example.url_short.record.UrlShort;
import com.example.url_short.repository.UrlShortRepository;

@Service
public class ShortedService {

    private final UrlShortRepository urlShortRepository;

    public ShortedService(UrlShortRepository urlShortRepository) {
        this.urlShortRepository = urlShortRepository;
    }

    public void procesarYguardarUrl(List<String> urls) {

        urls.forEach(url -> {
            String shortId = generateShortId();

            UrlShort entity = new UrlShort(shortId, url, LocalDateTime.now());

            urlShortRepository.save(entity);

        });
        

    }

    private String generateShortId() {
        
        return UUID.randomUUID().toString().substring(0, 6);
    }

}
