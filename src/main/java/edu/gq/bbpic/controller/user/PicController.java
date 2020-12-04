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
@RequestMapping("pic")
public class PicController {
    @Autowired
    private PicService picService;

    @GetMapping("picList")
    public ServerResponse getPicList(@RequestParam(defaultValue = "1") int currentPage,
                                    @RequestParam(defaultValue = "10") int pageSize,
                                    @RequestParam(defaultValue = "hot") String type,
                                    @RequestParam(defaultValue = "1") int enable) {

        return picService.getPicList(currentPage, pageSize, type, enable);
    }

    @GetMapping("picSetList")
    public ServerResponse getPicSetList(@RequestParam(defaultValue = "1") int currentPage,
                                        @RequestParam(defaultValue = "10") int pageSize,
                                        @RequestParam(defaultValue = "hot") String type,
                                        @RequestParam(defaultValue = "1") int enable) {

        return picService.getPicSetList(currentPage, pageSize, type, enable);
    }

    @PostMapping("uploadSinglePic")
    public ServerResponse uploadSinglePic(HttpServletRequest request) {
        MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
        MultipartFile file = ((MultipartHttpServletRequest) request).getFile("file");

        return picService.uploadSinglePic(file, params.getParameterMap());
    }

    @PostMapping("uploadPicToList")
    public ServerResponse uploadPicToList(HttpServletRequest request) {
        MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
        MultipartFile file = ((MultipartHttpServletRequest) request).getFile("file");

        return picService.uploadPicToList(file, params.getParameterMap());
    }

    @GetMapping()
    public ServerResponse getInfo(@RequestParam int id) {
        return new ServerResponse(Const.ResCode.SUCCEES, "ok", id);
    }
}
