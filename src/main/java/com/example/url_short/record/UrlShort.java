package com.example.url_short.record;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import com.fasterxml.jackson.annotation.JsonFormat;

@RedisHash(value = "url_short" , timeToLive = 86400)
public record UrlShort(
   @Id String id,
   @Indexed 
    String longUrl,
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime fechaCreacion
   

)implements Serializable
 {} 
