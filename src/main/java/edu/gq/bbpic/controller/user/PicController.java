package edu.gq.bbpic.controller.user;

import com.alibaba.fastjson.JSON;
import edu.gq.bbpic.common.Const;
import edu.gq.bbpic.common.ServerResponse;
import edu.gq.bbpic.service.PicService;
import edu.gq.bbpic.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("picture")
public class PicController {
    @Autowired
    private PicService picService;

    @PostMapping("addPic")
    public ServerResponse addPic(HttpServletRequest request) {
        MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
        MultipartFile file = ((MultipartHttpServletRequest) request).getFile("file");

        System.out.println(JSON.toJSON(params.getParameterMap()));

        return picService.addPic(file);
    }

    @GetMapping("category")
    public ServerResponse getCategory() {
        return picService.getCategory();
    }

    @GetMapping()
    public ServerResponse getInfo(@RequestParam int id) {
        return new ServerResponse(Const.ResCode.SUCCEES, "ok", id);
    }
}
