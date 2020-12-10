package edu.gq.bbpic.controller.user;

import com.alibaba.fastjson.JSON;
import edu.gq.bbpic.common.Const;
import edu.gq.bbpic.common.ServerResponse;
import edu.gq.bbpic.pojo.PicList;
import edu.gq.bbpic.pojo.Picture;
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
    @Autowired
    private UserService userService;

    @GetMapping("picList")
    public ServerResponse getPicList(@RequestParam(defaultValue = "1") int currentPage,
                                    @RequestParam(defaultValue = "10") int pageSize,
                                    @RequestParam(defaultValue = "new") String type,
                                    @RequestParam(defaultValue = "0") int enable,
                                    @RequestParam(defaultValue = "0") int categoryId) {

        return picService.getPicList(currentPage, pageSize, type, enable, categoryId);
    }

    @GetMapping("picSetList")
    public ServerResponse getPicSetList(@RequestParam(defaultValue = "1") int currentPage,
                                        @RequestParam(defaultValue = "10") int pageSize,
                                        @RequestParam(defaultValue = "new") String type,
                                        @RequestParam(defaultValue = "0") int enable,
                                        @RequestParam(defaultValue = "0") int categoryId) {

        return picService.getPicSetList(currentPage, pageSize, type, enable, categoryId);
    }

    @PostMapping("addPicList")
    public ServerResponse addPicList(@RequestBody Map map) {
        return picService.addPicList(map);
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

    // 管理员接口
    @PostMapping("updatePicture")
    public ServerResponse updatePicture(@RequestHeader Map<String, String> headers, @RequestBody Picture picture) {
        String token = headers.get(Const.AUTH);
        ServerResponse response = userService.checkAdminToken(token);
        if (response.getStatus() != Const.ResCode.SUCCEES) {
            return response;
        }
        return picService.updatePicture(picture);
    }

    @PostMapping("updatePicList")
    public ServerResponse updatePicList(@RequestHeader Map<String, String> headers, @RequestBody PicList picList) {
        String token = headers.get(Const.AUTH);
        ServerResponse response = userService.checkAdminToken(token);
        if (response.getStatus() != Const.ResCode.SUCCEES) {
            return response;
        }
        return picService.updatePicList(picList);
    }
}
