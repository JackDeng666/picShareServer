package edu.gq.bbpic.controller.user;

import edu.gq.bbpic.common.ServerResponse;
import edu.gq.bbpic.pojo.Collect;
import edu.gq.bbpic.pojo.Praise;
import edu.gq.bbpic.service.StaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("statistics")
public class StaController {
    @Autowired
    private StaService staService;

    @PostMapping("togglePraise")
    public ServerResponse togglePraise(@RequestBody Praise praise){
        return staService.togglePraise(praise);
    }

    @PostMapping("toggleCollect")
    public ServerResponse toggleCollect(@RequestBody Collect collect){
        return staService.toggleCollect(collect);
    }
}
