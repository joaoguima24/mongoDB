package academy.mindswap.mongo.Service;

import org.slf4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.time.LocalDateTime;

@Service
@EnableScheduling
public class WallStreetJournalService {

    @Cacheable("news")
    public Object getNews() {
        System.out.println("without cache");
        //String url = "https://newsapi.org/v2/everything?domains=wsj.com&apiKey=b75882da4f984e0b84e14b559c482de7";
        String url = "https://www.publico.pt/api/list/ultimas";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, Object.class);
    }

    @CacheEvict (value = "news",allEntries = true)
    //(cron = "seconds minutes hour dayOfMonth month dayOfWeek"
    @Scheduled (cron = "*/20 * * * * *")
    public void cacheEvict(){
        System.out.println("cache evict!"+ LocalDateTime.now());
    }
}
