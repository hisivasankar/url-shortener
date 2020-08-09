package com.sivasankr.urlshortener.urlservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class Advert {
    private String text;
    private String description;
    private String createdAt;
}
