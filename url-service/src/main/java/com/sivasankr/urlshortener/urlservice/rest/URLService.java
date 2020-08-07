package com.sivasankr.urlshortener.urlservice.rest;

import com.sivasankr.urlshortener.urlservice.model.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/url")
public class URLService {

//    @LoadBalanced
    @Autowired
    RestTemplate restClient;

    @GetMapping
    public List<URL> getURLs() {
        String url = "http://db-service/url";
        ResponseEntity<URL[]> response  = restClient.getForEntity(url, URL[].class);
        return Arrays.asList(response.getBody());
    }

    @GetMapping("/{shortURL}")
    public URL getURL(@PathVariable("shortURL") String shortURL) {
        return restClient.getForObject("http://db-service/url/" + shortURL, URL.class);
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
}
