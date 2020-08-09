package com.sivasankr.dbservice.rest;

import com.sivasankr.dbservice.dao.URLRepository;
import com.sivasankr.dbservice.defaults.Constants;
import com.sivasankr.dbservice.models.URLModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Constants.DB_SERVICE_ROOT)
public class URLService {

    @Autowired
    URLRepository urlRepo;

    @GetMapping("/url/{shortUrl}")
    public ResponseEntity<URLModel> getURL(@PathVariable("shortUrl") String shortUrl) {
        URLModel url = urlRepo.findByShortURL(shortUrl);

        if (url == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(url);
    }

    @PostMapping("/url")
    public boolean addNewURL(@RequestBody  URLModel url) {
        Optional<URLModel> obj = urlRepo.findById(url.getOriginalURL());
        if(obj.isEmpty()) {
            urlRepo.save(url);
        }
        return true;
    }

    @DeleteMapping("/url/{id}")
    public boolean deleteURL(@PathVariable("id") String shortURL) {
        URLModel obj = urlRepo.findByShortURL(shortURL);
        if(obj != null) {
            urlRepo.delete(obj);
        }
        return true;
    }

    @GetMapping("/url")
    public List<URLModel> getURLs() {
        List<URLModel> urls = urlRepo.findAll();
        return urls;
    }
}
