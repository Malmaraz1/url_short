package com.example.url_short.record;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record NewReponse(
    @JsonProperty("news_results")
    List<NewsItem> new_results
) {
    
    public record NewsItem(
        String link,
        List<Story> stories
    ) {}

    public record Story(
        String link
    ) {}
}
    

