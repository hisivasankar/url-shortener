package com.sivasankr.urlshortener.adsservice.rest;

import com.sivasankr.urlshortener.adsservice.models.Advert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RestController
public class AdvertController {
    private static final Logger logger = LoggerFactory.getLogger(AdvertController.class);
    private static final int ADS_COUNT = 9;

    @Autowired
    RestTemplate restClient;

    @GetMapping("/ads/random")
    public Advert getRandomAdvert() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(ADS_COUNT + 1);

        if (randomNumber <= 0) {
            randomNumber += 1;
        }

        logger.info("Get Ad: #{} from DB-Service", randomNumber);

        Advert advert = new Advert();
        try {
            String url = String.format("http://db-service/ads/%s", randomNumber);
            logger.info("Ad URL: {}", url);
            advert = restClient.getForObject(url, Advert.class);
        } catch (Exception ex) {
            logger.error("Failed to get ad from the DB-Service. So, returning default ad. Exception: {}", ex);
            advert.setText("Random Ad");
            advert.setDescription("Real ad is supposed to come here!!");
        }
        return advert;
    }
}
