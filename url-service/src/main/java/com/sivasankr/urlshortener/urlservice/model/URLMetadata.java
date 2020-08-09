package com.sivasankr.urlshortener.urlservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class URLMetadata {
    private URL url;
    private Advert advert;
}
