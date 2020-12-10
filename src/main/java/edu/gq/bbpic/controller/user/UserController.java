package edu.gq.bbpic.controller.user;

import edu.gq.bbpic.common.Const;
import edu.gq.bbpic.common.ServerResponse;
import edu.gq.bbpic.pojo.User;
import edu.gq.bbpic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     */
    @PostMapping("login")
    public ServerResponse login(@RequestBody User user) {
        return userService.login(user.getAccount(), user.getPassword());
    }


    /**
     * 超级管理员登录
     */
    @PostMapping("adminLogin")
    public ServerResponse adminLogin(@RequestBody User user) {
        return userService.adminLogin(user.getAccount(), user.getPassword());
    }

    /**
     * 用户注册
     */
    @PostMapping("register")
    public ServerResponse register(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping("getUserList")
    public ServerResponse getUserList(int currentPage, int pageSize) {
        return userService.getUserList(currentPage, pageSize);
    }
//
//    @GetMapping("searchUser")
//    public ServerResponse searchUser(String searchKeyWord) {
//        return userService.searchUser(searchKeyWord);
//    }

    @PostMapping("updateUser")
    public ServerResponse updateUser(@RequestHeader Map<String, String> headers, @RequestBody User user){
        String token = headers.get(Const.AUTH);
        ServerResponse response = userService.checkAdminToken(token);
        if (response.getStatus() != Const.ResCode.SUCCEES) {
            return response;
        }
        return userService.updateUser(user);
    }
}
