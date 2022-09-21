package academy.mindswap.mongo.Controller;


import academy.mindswap.mongo.Service.WallStreetJournalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get")
public class WallStreetJournalController {
    private final WallStreetJournalService wallStreetJournalService;

    public WallStreetJournalController(WallStreetJournalService wallStreetJournalService) {
        this.wallStreetJournalService = wallStreetJournalService;
    }

    @GetMapping("/news")
    public Object getnewsInCache(){
        return wallStreetJournalService.getNews();
    }

}
