package com.example.url_short.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.example.url_short.client.NewsClient;

import lombok.AllArgsConstructor;

@Service
public class ServicioDeNews {
    private final NewsClient newsClient;

    public ServicioDeNews(NewsClient newsClient) {
        this.newsClient = newsClient;
    }

    public List<String> url_news() {

        return newsClient.news().new_results().stream().flatMap(item -> {

            if (item.stories() != null && !item.stories().isEmpty()) {
                return item.stories().stream().map(story -> story.link());
            }
            return Stream.of(item.link());

        }).filter(Objects::nonNull)
                .toList();

    }

}
