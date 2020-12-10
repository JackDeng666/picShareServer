package edu.gq.bbpic.controller.user;

import edu.gq.bbpic.common.ServerResponse;
import edu.gq.bbpic.pojo.Collect;
import edu.gq.bbpic.pojo.Praise;
import edu.gq.bbpic.service.StaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("statistics")
public class StaController {
    @Autowired
    private StaService staService;

    @GetMapping("getPraiseAndCollectInfo")
    public ServerResponse getPraiseAndCollectInfo(@RequestParam(defaultValue = "0") int userId,
                                                  @RequestParam(defaultValue = "0") int pictureId){
        return staService.getPraiseAndCollectInfo(userId, pictureId);
    }

    @PostMapping("togglePraise")
    public ServerResponse togglePraise(@RequestBody Praise praise){
        return staService.togglePraise(praise);
    }

    @PostMapping("toggleCollect")
    public ServerResponse toggleCollect(@RequestBody Collect collect){
        return staService.toggleCollect(collect);
    }
}
