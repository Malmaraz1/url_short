package com.example.url_short.task;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.url_short.Service.ServicioDeNews;
import com.example.url_short.Service.ShortedService;
import com.example.url_short.client.NewsClient;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Component
public class NewsSyncTask {

    private final ServicioDeNews servicioDeNews;
    private final ShortedService shortedService;
    

    @Scheduled(cron = "0 0 */10 * * *")
    public void updateTrendingNews() {
        log.info("Buscando noticias nuevas...");

        List<String> urlsNews = servicioDeNews.url_news();
        shortedService.procesarYguardarUrl(urlsNews);

        log.info("Noticias guardadas en Redis correctamente.");

    }
}
