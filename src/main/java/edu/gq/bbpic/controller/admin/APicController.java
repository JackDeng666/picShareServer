package edu.gq.bbpic.controller.admin;

import edu.gq.bbpic.common.Const;
import edu.gq.bbpic.common.ServerResponse;
import edu.gq.bbpic.pojo.PicList;
import edu.gq.bbpic.pojo.Picture;
import edu.gq.bbpic.service.PicService;
import edu.gq.bbpic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("pic")
public class APicController {
    @Autowired
    private PicService picService;
    @Autowired
    private UserService userService;

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
