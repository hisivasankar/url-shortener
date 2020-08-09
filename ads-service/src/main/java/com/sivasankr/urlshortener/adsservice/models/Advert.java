package com.sivasankr.urlshortener.adsservice.models;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public @Data class Advert {
    private String text;
    private String description;
    private String createdAt;
}
