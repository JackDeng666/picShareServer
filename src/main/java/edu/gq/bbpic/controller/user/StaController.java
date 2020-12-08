package edu.gq.bbpic.controller.user;

import edu.gq.bbpic.dao.CollectMapper;
import edu.gq.bbpic.dao.PraiseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("statistics")
public class StaController {
    @Autowired
    PraiseMapper praiseMapper;
    @Autowired
    CollectMapper collectMapper;


}
