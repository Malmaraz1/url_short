package com.example.url_short.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class url {

    private String url_original;
    private String url_short;

    
}
