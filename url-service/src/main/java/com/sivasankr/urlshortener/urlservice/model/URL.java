package com.sivasankr.urlshortener.urlservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class URL {
    private String originalURL;
    private String shortURL;
    private Date createdAt;
}
