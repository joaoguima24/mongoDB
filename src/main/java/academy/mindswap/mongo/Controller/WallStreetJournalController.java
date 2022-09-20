package academy.mindswap.mongo.Controller;


import org.bson.assertions.Assertions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/get")
public class WallStreetJournalController {
    @GetMapping("/news")
    public Object getNews() {
        String url = "https://newsapi.org/v2/everything?domains=wsj.com&apiKey=b75882da4f984e0b84e14b559c482de7";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, Object.class);
    }

}
