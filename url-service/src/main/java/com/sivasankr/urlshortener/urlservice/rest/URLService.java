package com.sivasankr.urlshortener.urlservice.rest;

import com.sivasankr.urlshortener.urlservice.model.Advert;
import com.sivasankr.urlshortener.urlservice.model.URL;
import com.sivasankr.urlshortener.urlservice.model.URLMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/url")
public class URLService {
    private static final Logger logger = LoggerFactory.getLogger(URLService.class);

    @Autowired
    RestTemplate restClient;

    @GetMapping
    public List<URL> getURLs() {
        String url = "http://db-service/url";
        ResponseEntity<URL[]> response  = restClient.getForEntity(url, URL[].class);
        return Arrays.asList(response.getBody());
    }

    @GetMapping("/{shortURL}")
    public ResponseEntity<URLMetadata> getURL(@PathVariable("shortURL") String shortURL) {
        Advert ad = getRandomAdvert();
        ResponseEntity<URLMetadata> response = null;
        URL urlInfo = null;

        try {
            urlInfo = restClient.getForObject("http://db-service/url/" + shortURL, URL.class);
        } catch (Exception e) {
            return ResponseEntity.ok(new URLMetadata(null, ad));
        }

        URLMetadata metadata = new URLMetadata(urlInfo, ad);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, urlInfo.getOriginalURL());

        response = new ResponseEntity<URLMetadata>(metadata, headers, HttpStatus.OK);

        return response;
    }

    @PostMapping("/")
    public boolean createURL(@RequestBody URL url) {
        restClient.postForObject("http://db-service/url", url, URL.class);
        return true;
    }

    @DeleteMapping("/url/{id}")
    public boolean deleteURL(@PathVariable String id) {
        restClient.delete("http://db-service/url/" + id);
        return true;
    }

    private Advert getRandomAdvert() {
        String url = "http://ads-service/ads/random";
        Advert advert = null;
        try {
            advert = restClient.getForObject(url, Advert.class);
        } catch (Exception ex) {
            logger.error("Failed to get random ad. Exception: {}", ex);
        }
        return advert;
    }
}
