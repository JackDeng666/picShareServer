package edu.gq.bbpic.controller.admin;

import edu.gq.bbpic.common.Const;
import edu.gq.bbpic.common.ServerResponse;
import edu.gq.bbpic.pojo.User;
import edu.gq.bbpic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("user")
public class AUserController {
    @Autowired
    private UserService userService;

    @GetMapping("getUserList")
    public ServerResponse getUserList(@RequestHeader Map<String, String> headers, int currentPage, int pageSize) {
        String token = headers.get(Const.AUTH);
        ServerResponse response = userService.checkAdminToken(token);
        if (response.getStatus() != Const.ResCode.SUCCEES) {
            return response;
        }
        return userService.getUserList(currentPage, pageSize);
    }

//    @GetMapping("searchUser")
//    public ServerResponse searchUser(String searchKeyWord) {
//        return userService.searchUser(searchKeyWord);
//    }

    @PostMapping("updateEnable")
    public ServerResponse updateUser(@RequestHeader Map<String, String> headers, @RequestBody User user){
        String token = headers.get(Const.AUTH);
        ServerResponse response = userService.checkAdminToken(token);
        if (response.getStatus() != Const.ResCode.SUCCEES) {
            return response;
        }
        return userService.updateEnable(user);
    }
}
